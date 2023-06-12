/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import dao.EstruturaDAO;
import dao.ItemDAO;
import entidade.Estrutura;
import entidade.Item;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Fabricio Pretto
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static int[] dddsTelefoneBrasil = {11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32, 33, 34, 35, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 55, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 73, 74, 75, 77, 79, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCEP(String cep) {
        if ((cep == null) || (cep.length() != 8)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA(int d, int m, int a) {

        boolean correto = true;

        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));

    }

    public static boolean validarHoraFormatada(String horaComFormato) {
        String[] hora = horaComFormato.split(":");
        if (Integer.parseInt(hora[0]) < 24 && Integer.parseInt(hora[1]) < 60) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarTelefone(String campo) {
        if (campo.trim().length() != 11) {
            return false;
        }

        int ddd = Integer.parseInt(campo.substring(0, 2));
        boolean dddMatch = false;
        for (int i = 0; i < dddsTelefoneBrasil.length; i++) {
            if (ddd == dddsTelefoneBrasil[i]) {
                dddMatch = true;
                break;
            }
        }

        if (!dddMatch) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean validarCampoemBranco(String campo) {
        if (campo.equals(null) || campo.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean ValidarJTFObrigatorio(JTextField campo) {
        //Validar se possui algum JTextField obrigatório em branco
        if (!validarCampoemBranco(campo.getText())) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            campo.setBackground(Color.white);
            return true;
        }
    }

    public static boolean ValidarPasswdObrigatorio(JPasswordField campo) {
        //Validar se possui algum JPasswordField obrigatório em branco
        if (!Validacao.validarCampoemBranco(String.valueOf(campo.getPassword()))) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            campo.setBackground(Color.white);
            return true;
        }
    }

    public static boolean testarCombo(JComboBox campo) {
        //Testa se o ComboBom foi retirado da posição=0 (SELECIONE)
        if (campo.getSelectedIndex() == 0) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            campo.setBackground(Color.white);
            return true;
        }
    }

    //Valida na hora da digitação se o usuario está digitando apenas numeros. Pode conter apenas uma "," ou "."
    public static boolean ValidarDecimal(JTextField campo, java.awt.event.KeyEvent evt) {
        String caracteres = "0987654321,.";
        String unico = ".,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if (campo.getText().contains(",") || campo.getText().contains(".")) {
            if (unico.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        }
        return true;
    }

    //Valida se o usuario está digitando apenas um @. Deve conter "@" e "." no email.
    public static boolean ValidarEmail(JTextField campo) {
        // Verificar se o email contém exatamente um caractere "@"
        int quantidadeArrobas = 0;
        for (int i = 0; i < campo.getText().length(); i++) {
            if (campo.getText().charAt(i) == '@') {
                quantidadeArrobas++;
            }
        }
        if (quantidadeArrobas != 1) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        }

        // Verificar se o email contém pelo menos um ponto após o "@"
        int posicaoArroba = campo.getText().indexOf("@");
        int posicaoUltimoPonto = campo.getText().lastIndexOf(".");
        if (posicaoUltimoPonto < posicaoArroba) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        }

        campo.setBackground(Color.white);
        return true;
    }

    public static boolean ValidarSenhaForte(JPasswordField jPasswordField) {
        // Verificar comprimento mínimo
        if (jPasswordField.getPassword().length < 8) {
            return false;
        }

        // Verificar caracteres especiais
        boolean contemCaractereEspecial = false;
        for (char c : jPasswordField.getPassword()) {
            if ("!@#$%^&*()_+|~-=`{}[]:\";'<>?,./".indexOf(c) != -1) {
                contemCaractereEspecial = true;
                break;
            }
        }
        if (!contemCaractereEspecial) {
            jPasswordField.setBackground(Color.decode("#FF9696"));
            return false;
        }

        // Verificar letras maiúsculas e minúsculas
        boolean contemLetraMaiuscula = false;
        boolean contemLetraMinuscula = false;
        for (char c : jPasswordField.getPassword()) {
            if (Character.isUpperCase(c)) {
                contemLetraMaiuscula = true;
            } else if (Character.isLowerCase(c)) {
                contemLetraMinuscula = true;
            }
        }
        if (!contemLetraMaiuscula || !contemLetraMinuscula) {
            jPasswordField.setBackground(Color.decode("#FF9696"));
            return false;
        }

        // Verificar números
        boolean contemNumero = false;
        for (char c : jPasswordField.getPassword()) {
            if (Character.isDigit(c)) {
                contemNumero = true;
                break;
            }
        }
        if (!contemNumero) {
            jPasswordField.setBackground(Color.decode("#FF9696"));
            return false;
        }

        // A senha atende aos critérios de senha forte
        jPasswordField.setBackground(Color.WHITE);
        return true;

    }

    public static ArrayList<Object[]> ValidarEstoque(int id_item, double qtde, String und, double perda, JTable tabela, String tipoMovimento) {
        boolean estoqueOk = true;
        ArrayList<Object[]> dadosRetorno = new ArrayList<>();

        int rowCount = tabela.getRowCount();
        ArrayList<Object[]> columnData = new ArrayList<>();

        Item itemEstoque = new ItemDAO().consultarId(id_item);
        double consumoItem = ConverterQtdeEstoque(id_item, qtde, und);
        double estoqueItem = itemEstoque.getQtde_estoque();

        int id_insumo;
        double qtdeConsumoInsumoAdicionado;
        double qtdeConsumoInsumo;
        double qtdaEstoqueInsumo;
        Item insumoEstoque;
        ArrayList<Estrutura> estruturaItem;
        ArrayList<Object[]> estoqueEstruturaTabela = new ArrayList<>();
        ArrayList<Object[]> consumoEstrutura = new ArrayList<>();

        for (int row = 0; row < rowCount; row++) {
            String Column1 = tabela.getValueAt(row, 1).toString();
            String[] parts = Column1.split(" -|- ");

            Object idItem = parts[0];
            Object qtdeItem = Double.parseDouble(tabela.getValueAt(row, 3).toString().replace(",", "."));
            Object undMedidaItem = tabela.getValueAt(row, 4);
            Object perdaItem = Double.parseDouble(tabela.getValueAt(row, 5).toString().replace(",", ".").replace("R$  ", ""));

            Object[] rowData = {idItem, qtdeItem, undMedidaItem, perdaItem};
            columnData.add(rowData);
        }

        if (tipoMovimento.equals("producao")) {
            estruturaItem = new EstruturaDAO().consultarItemID(id_item);
            for (int j = 0; j < estruturaItem.size(); j++) {
                id_insumo = estruturaItem.get(j).getInsumo_id();
                insumoEstoque = new ItemDAO().consultarId(id_insumo);
                qtdaEstoqueInsumo = insumoEstoque.getQtde_estoque();
                Object[] objetoEstoque = new Object[]{id_insumo, qtdaEstoqueInsumo};
                estoqueEstruturaTabela.add(objetoEstoque);

                qtdeConsumoInsumo = (consumoItem + perda)
                        * ConverterQtdeEstoque(id_insumo, estruturaItem.get(j).getQtde_insumo(), estruturaItem.get(j).getUnd_medida());
                Object[] objetoConsumo = new Object[]{id_insumo, qtdeConsumoInsumo};
                consumoEstrutura.add(objetoConsumo);
            }
        }

        for (int i = 0; i < columnData.size(); i++) {
            Object[] rowData = columnData.get(i);
            Object valueId = rowData[0];
            Object valueQtde = rowData[1];
            Object valueUnd = rowData[2];
            Object valuePerda = rowData[3];

            if (tipoMovimento.equals("venda") && Integer.parseInt(valueId.toString()) == id_item) {
                consumoItem = consumoItem + ConverterQtdeEstoque(id_item, Double.parseDouble(valueQtde.toString()), valueUnd.toString());
            }

            if (tipoMovimento.equals("producao")) {
                estruturaItem = new EstruturaDAO().consultarItemID(Integer.parseInt(valueId.toString()));

                for (int j = 0; j < estruturaItem.size(); j++) {
                    boolean id_insumo_encontrado_estoque = false;
                    boolean id_insumo_encontrado_consumo = false;

                    //VERIFICAR ESTOQUE E ARMAZENAR VALORES NUMA ARRAYLIST
                    id_insumo = estruturaItem.get(j).getInsumo_id();

                    //Testar se o insumo do item a ser adicionado ja está na lista de insumoEstoque
                    for (int k = 0; k < estoqueEstruturaTabela.size(); k++) {
                        Object[] estoqueTabela = estoqueEstruturaTabela.get(k);
                        if (Integer.parseInt(estoqueTabela[0].toString()) == id_insumo) {
                            id_insumo_encontrado_estoque = true;
                        }
                    }

                    if (!id_insumo_encontrado_estoque) {
                        insumoEstoque = new ItemDAO().consultarId(id_insumo);
                        qtdaEstoqueInsumo = insumoEstoque.getQtde_estoque();
                        Object[] objetoEstoque = new Object[]{id_insumo, qtdaEstoqueInsumo};
                        estoqueEstruturaTabela.add(objetoEstoque);
                    }

                    //VERIFICAR CONSUMO E ARMAZENAR VALORES NUMA ARRAYLIST
                    //Testar se o insumo do item a ser adicionado ja está na lista de consumoEstrutura
                    for (int k = 0; k < consumoEstrutura.size(); k++) {
                        Object[] consumoTabela = consumoEstrutura.get(k);

                        if (Integer.parseInt(consumoTabela[0].toString()) == id_insumo) {
                            id_insumo_encontrado_consumo = true;
                            qtdeConsumoInsumo = (ConverterQtdeEstoque(Integer.parseInt(valueId.toString()), Double.parseDouble(valueQtde.toString()), valueUnd.toString()) + Double.parseDouble(valuePerda.toString()))
                                    * ConverterQtdeEstoque(id_insumo, estruturaItem.get(j).getQtde_insumo(), estruturaItem.get(j).getUnd_medida());
                            double novoConsumo = Double.parseDouble(consumoTabela[1].toString()) + qtdeConsumoInsumo;
                            consumoTabela[1] = novoConsumo;
                        }
                    }

                    if (!id_insumo_encontrado_consumo) {
                        qtdeConsumoInsumoAdicionado = (ConverterQtdeEstoque(Integer.parseInt(valueId.toString()), Double.parseDouble(valueQtde.toString()), valueUnd.toString()) + Double.parseDouble(valuePerda.toString()))
                                * ConverterQtdeEstoque(id_insumo, estruturaItem.get(j).getQtde_insumo(), estruturaItem.get(j).getUnd_medida());
                        Object[] object = new Object[]{id_insumo, qtdeConsumoInsumoAdicionado};
                        consumoEstrutura.add(object);
                    }

                }
            }
        }

        if (tipoMovimento.equals("venda")) {
            if (Formatacao.ArredondarDecimal4casas(consumoItem) > Formatacao.ArredondarDecimal4casas(estoqueItem)) {
                estoqueOk = false;
            }
            Object[] dado = {String.valueOf(estoqueOk), id_item, Formatacao.ArredondarDecimal4casas(consumoItem), Formatacao.ArredondarDecimal4casas(estoqueItem)};
            dadosRetorno.add(dado);

        } else if (tipoMovimento.equals("producao")) {

            double qtdeEstoqueInsumo;
            for (int i = 0; i < consumoEstrutura.size(); i++) {
                Object[] objectConsumo = consumoEstrutura.get(i);
                Object[] objectEstoque = estoqueEstruturaTabela.get(i);
                qtdeConsumoInsumo = Formatacao.ArredondarDecimal4casas(Double.parseDouble(objectConsumo[1].toString()));
                qtdeEstoqueInsumo = Formatacao.ArredondarDecimal4casas(Double.parseDouble(objectEstoque[1].toString()));

                if (qtdeConsumoInsumo > qtdeEstoqueInsumo) {
                    estoqueOk = false;
                } else {
                    estoqueOk = true;
                }
                Object[] dado = {String.valueOf(estoqueOk), objectConsumo[0].toString(), qtdeConsumoInsumo, qtdeEstoqueInsumo};
                dadosRetorno.add(dado);
            }
        }

        return dadosRetorno;
    }

    public static double ConverterQtdeEstoque(int id_item, double qtde, String und) {
        Item itemEstoque = new ItemDAO().consultarId(id_item);
        double consumoEstoque;
        if (itemEstoque.getUnidade_medida().equals(und)) {
            consumoEstoque = qtde;
        } else if (und.equals(itemEstoque.getUnd_conv1())) {
            consumoEstoque = qtde * itemEstoque.getConv2();
        } else {
            consumoEstoque = qtde / itemEstoque.getConv2();
        }

        return consumoEstoque;
    }

    public static ArrayList<Object[]> AjustarEstoqueInsumosProdução(int id_item, double qtde_Item, double perda) {
        ArrayList<Estrutura> estruturaItem = new EstruturaDAO().consultarItemID(id_item);
        ArrayList<Object[]> retornoInsumos = new ArrayList<>();
        int id_insumo;
        double qtdeConsumoInsumo;

        for (int j = 0; j < estruturaItem.size(); j++) {
            id_insumo = estruturaItem.get(j).getInsumo_id();
            qtdeConsumoInsumo = (qtde_Item + perda)
                    * ConverterQtdeEstoque(id_insumo, estruturaItem.get(j).getQtde_insumo(), estruturaItem.get(j).getUnd_medida());

            System.out.println("OBJ id_insumo " + id_insumo);
            System.out.println("OBJ qtdeConsumoInsumo " + qtdeConsumoInsumo);
            Object[] dado = {id_insumo, qtdeConsumoInsumo};
            retornoInsumos.add(dado);
        }
        return retornoInsumos;
    }

}
