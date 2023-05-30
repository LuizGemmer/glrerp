package apoio;

import entidade.Grupo;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;

    // construtor 1
    public void popularCombo(String tabela, JComboBox combo) {

        combo.removeAllItems();
        if (tabela.equals("grupo")) {
            Grupo item = new Grupo();
            item.setId(0);
            item.setDescricao("SELECIONE");
            combo.addItem(item);

            try {
                resultado = new ConexaoBD().getConnection().createStatement().executeQuery(""
                        + "SELECT * "
                        + "FROM " + tabela + " "
                        + "WHERE ativo='true' "
                        + "ORDER BY 3");

                if (resultado.isBeforeFirst()) {
                    while (resultado.next()) {
                        item = new Grupo();
                        item.setId(resultado.getInt(1));
                        item.setDescricao(resultado.getString(2));
                        item.setTipo(resultado.getString(3));

                        combo.addItem(item);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao popular Combo = " + e.toString());
            }

        } else {
            ComboItem item = new ComboItem();
            item.setCodigo(0);
            item.setDescricao("SELECIONE");
            combo.addItem(item);

            try {
                resultado = new ConexaoBD().getConnection().createStatement().executeQuery(""
                        + "SELECT * "
                        + "FROM " + tabela + " "
                        + "WHERE ativo='true' "
                        + "ORDER BY 2");

                if (resultado.isBeforeFirst()) {
                    while (resultado.next()) {
                        item = new ComboItem();
                        item.setCodigo(resultado.getInt(1));
                        item.setDescricao(resultado.getString(2));

                        combo.addItem(item);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao popular Combo = " + e.toString());
            }
        }

    }

    // construtor 2
    public void popularCombo(String tabela, String campo1, String campo2, JComboBox combo, String complementoSQL) {

        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("SELECIONAR");
        combo.addItem(item);

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery(""
                    + "select * "
                    + "from " + tabela + " "
                    + "" + complementoSQL);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItem();
                    item.setCodigo(resultado.getInt(campo1));
                    item.setDescricao(resultado.getString(campo2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItem item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItem) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    public void definirComboGrupo(JComboBox combo, Grupo item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((Grupo) combo.getItemAt(i)).getId() == (item.getId())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    // Popular ComboBox da tela de Estrutura - Combo para unidades de medida
    public void popularComboUndMedida(int id, JComboBox combo) {

        combo.removeAllItems();
        ComboItem item = new ComboItem();

        try {
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "CASE WHEN "
                    + "und_conv1='' OR und_conv2='' THEN unidade_medida "
                    + "ELSE CONCAT (und_conv1, ',', und_conv2) END "
                    + "FROM item "
                    + "WHERE id=" + id);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItem();
                    item.setUnd_medida(resultado.getString(1));
                    if (item.getUnd_medida().contains(",")) {

                        String[] partes = item.getUnd_medida().split(",");
                        for (String parte : partes) {
                            combo.addItem(parte.trim());
                        }
                    } else {
                        combo.addItem(item);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

}
