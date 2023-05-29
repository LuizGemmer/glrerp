package apoio;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class MarginTextField extends JTextField {
    private static final int MARGIN_LENGTH = 5; // Defina o tamanho da margem interna desejada aqui

    public MarginTextField() {
        super();
        setMarginDocument();
    }

    public MarginTextField(String text) {
        super(text);
        setMarginDocument();
    }

    public MarginTextField(int columns) {
        super(columns);
        setMarginDocument();
    }

    public MarginTextField(String text, int columns) {
        super(text, columns);
        setMarginDocument();
    }

    private void setMarginDocument() {
        Document document = getDocument();
        if (document instanceof PlainDocument) {
            ((PlainDocument) document).setDocumentFilter(new DocumentFilter() {
                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                        throws BadLocationException {
                    if (offset < MARGIN_LENGTH) {
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