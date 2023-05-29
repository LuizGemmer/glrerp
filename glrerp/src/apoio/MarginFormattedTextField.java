package apoio;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class MarginFormattedTextField extends JFormattedTextField {

    private static final int MARGIN_LENGTH = 20; // Defina o tamanho da margem interna desejada aqui

    public MarginFormattedTextField() {
        super();
        setMarginDocument();
    }

    public MarginFormattedTextField(AbstractFormatter formatter) {
        super(formatter);
        setMarginDocument();
    }

    public MarginFormattedTextField(AbstractFormatterFactory factory) {
        super(factory);
        setMarginDocument();
    }

    private void setMarginDocument() {
        Document document = getDocument();
        if (document instanceof PlainDocument) {
            ((PlainDocument) document).setDocumentFilter(new DocumentFilter() {
                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                        throws BadLocationException {
                    if (offset < MARGIN_LENGTH || offset + length < MARGIN_LENGTH) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }

                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                        throws BadLocationException {
                    if (offset < MARGIN_LENGTH) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
            });
        }
    }
}
