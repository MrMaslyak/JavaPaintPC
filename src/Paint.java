import java.awt.BasicStroke;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Paint extends JFrame implements ActionListener, MouseMotionListener {
    Color color = Color.BLACK;
    private int x;
    private int y;
    private CircleButton bigButton;
    private boolean isDragging = false;
    private int lineWidth = 1;
    private int textY = 160;
    private ArrayList<JLabel> points = new ArrayList<JLabel>();

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }


    Paint() {
        setTitle("Paint");
        setSize(1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setForeground(Color.white);
        setLayout(null);
        addMouseMotionListener(this);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, getWidth(), 150);
        isDragging = true;
        panel.setBackground(Color.decode("#E6E6FA"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                isDragging = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isDragging = false;
            }
        });
        add(panel);

        JPanel panelKey = new JPanel();
        panelKey.setBounds(50, 20, 150, 100);
        panelKey.setBackground(Color.decode("#E6E6FA"));
        panelKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelKey.setLayout(null);
        panelKey.setOpaque(true);
        add(panelKey);
        panel.add(panelKey);

        JLabel textInstruments = new JLabel("Instruments");
        textInstruments.setFont(new Font("Arial", Font.ITALIC, 15));
        textInstruments.setBounds(85, 120, 80, 30);
        add(textInstruments);
        panel.add(textInstruments);

        Button bFill = createButtonKey("F", 30, 10);
        bFill.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(bigButton.getColor());
                getContentPane().setForeground(bigButton.getColor());
                repaint();

            }
        });
        add(bFill);
        panel.add(bFill);
        panelKey.add(bFill);

        Button bLastik = createButtonKey("L", 90, 10);
        bLastik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = new Color(237, 237, 237);
            }
        });
        add(bLastik);
        panel.add(bLastik);
        panelKey.add(bLastik);

        Button bPencil = createButtonKey("P", 60, 50);
        bPencil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = Color.BLACK;
            }
        });
        add(bPencil);
        panel.add(bPencil);
        panelKey.add(bPencil);


        JTextField textField = new JTextField();
        textField.setBounds(230, 22, 150, 75);
        add(textField);
        panel.add(textField);

        Button bText = new Button("Send");
        bText.setBounds(275, 117, 60, 30);
        bText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.setText("");
                if(!text.isEmpty()){
                    JLabel labelForMassege = new JLabel();
                    labelForMassege.setBounds(50, textY, 300, 30);
                    labelForMassege.setFont(new Font("Arial", Font.ITALIC, 22));
                    labelForMassege.setText(text);
                    getContentPane().add(labelForMassege);
                    points.add(labelForMassege);
                    textY += 40;
                    repaint();

                }
            }
        });
        add(bText);
        panel.add(bText);

        JLabel massage = new JLabel("Text");
        massage.setFont(new Font("Arial", Font.ITALIC, 15));
        massage.setBounds(290, 90, 80, 30);
        add(massage);
        panel.add(massage);



        JLabel textValue = new JLabel("0");
        textValue.setFont(new Font("Arial", Font.ITALIC, 30));
        textValue.setBounds(385, 60, 55, 30);
        add(textValue);
        panel.add(textValue);

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, 99);
        scrollBar.setBounds(420, 20, 20, 100);
        isDragging = true;
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                lineWidth = e.getValue();
                setLineWidth(lineWidth);
                textValue.setText(String.valueOf(getLineWidth()));
            }
        });
        add(scrollBar);
        panel.add(scrollBar);


        JLabel textValueValue = new JLabel("Value");
        textValueValue.setFont(new Font("Arial", Font.ITALIC, 15));
        textValueValue.setBounds(412, 115, 100, 30);
        add(textValueValue);
        panel.add(textValueValue);

        JLabel textColor = new JLabel("Color");
        textColor.setFont(new Font("Arial", Font.ITALIC, 15));
        textColor.setBounds(690, 95, 100, 30);
        add(textColor);
        panel.add(textColor);

        JLabel textClear = new JLabel("Clear");
        textClear.setFont(new Font("Arial", Font.ITALIC, 15));
        textClear.setBounds(912, 95, 100, 30);
        add(textClear);
        panel.add(textClear);


        bigButton = createBigButton();
        add(bigButton);
        panel.add(bigButton);

        CircleButton bIndigo = createButton(Color.decode("#4B0082"), 630, 25);
        add(bIndigo);
        panel.add(bIndigo);

        CircleButton bMediumPurple = createButton(Color.decode("#9370DB"), 630, 60);
        add(bMediumPurple);
        panel.add(bMediumPurple);

        CircleButton bDeepPink = createButton(Color.decode("#ff1493"), 665, 25);
        add(bDeepPink);
        panel.add(bDeepPink);

        CircleButton bHotPink = createButton(Color.decode("#ff69b4"), 665, 60);
        add(bHotPink);
        panel.add(bHotPink);

        CircleButton bRed = createButton(Color.RED, 700, 25);
        add(bRed);
        panel.add(bRed);

        CircleButton bDarkRed = createButton(new Color(137, 8, 28), 700, 60);
        add(bDarkRed);
        panel.add(bDarkRed);

        CircleButton bBlue = createButton(Color.BLUE, 735, 25);
        add(bBlue);
        panel.add(bBlue);

        CircleButton bLBlue = createButton(Color.decode("#00ffe6"), 735, 60);
        add(bLBlue);
        panel.add(bLBlue);

        CircleButton bGreen = createButton(Color.GREEN, 770, 25);
        add(bGreen);
        panel.add(bGreen);

        CircleButton bDarkGreen = createButton(new Color(27, 132, 7), 770, 60);
        add(bDarkGreen);
        panel.add(bDarkGreen);


        CircleButton bPink = createButton(Color.PINK, 805, 25);
        add(bPink);
        panel.add(bPink);

        CircleButton bPurple = createButton(Color.MAGENTA, 805, 60);
        add(bPurple);
        panel.add(bPurple);

        CircleButton bGrey = createButton(Color.GRAY, 840, 25);
        add(bGrey);
        panel.add(bGrey);

        CircleButton bLightGrey = createButton(Color.LIGHT_GRAY, 840, 60);
        add(bLightGrey);
        panel.add(bLightGrey);

        CircleButton bOrange = createButton(new Color(253, 176, 10), 875, 25);
        add(bOrange);
        panel.add(bOrange);

        CircleButton bYellow = createButton(Color.YELLOW, 875, 60);
        add(bYellow);
        panel.add(bYellow);

        CircleButton bBlack = createButton(Color.BLACK, 910, 25);
        add(bBlack);
        panel.add(bBlack);

        CircleButton bWhite = createButton(Color.WHITE, 910, 60);
        add(bWhite);
        panel.add(bWhite);

        CircleButton bBrown = createButton(Color.decode("#964B00"), 945, 25);
        add(bBrown);
        panel.add(bBrown);

        CircleButton bAntiqueWhite = createButton(Color.decode("#FAEBD7"), 945, 60);
        add(bAntiqueWhite);
        panel.add(bAntiqueWhite);

        Button bClear = new Button("C");
        bClear.setBounds(900, 25, 60, 65);
        bClear.addActionListener(this);
        bClear.setFont(new Font("Arial", Font.BOLD, 40));
        bClear.setBackground(Color.decode("#D3D3D3"));
        bClear.setForeground(Color.BLACK);
        bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                getContentPane().setBackground(new Color(237, 237, 237));
                points.forEach(getContentPane()::remove);
                g.fillRect(0, 0, getWidth(), getHeight());
                repaint();
            }
        });
        add(bClear);
        panel.add(bClear);

        setVisible(true);
    }


    private CircleButton createButton(Color colorB, int x, int y) { //gpt подсказал , что оказывается так можно делать в JFrame и экономить милионны строк лишних
        isDragging = true;
        CircleButton button = new CircleButton(colorB);
        button.setBounds(x - 90, y, 30, 30);
        button.addActionListener(this);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                color = colorB;
                bigButton.setColor(color);
                bigButton.repaint();

            }
        });
        return button;
    }

    private Button createButtonKey(String name, int x, int y) {
        isDragging = true;
        Button button = new Button(name);
        button.setBounds(x, y, 30, 30);
        button.addActionListener(this);
        button.setBackground(Color.decode("#D3D3D3"));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Pacifico", Font.ITALIC, 15));
        return button;
    }

    private CircleButton createBigButton() {
        isDragging = true;
        CircleButton button = new CircleButton(Color.BLACK);
        button.setBounds(475, 25, 60, 60);
        button.addActionListener(this);
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isDragging) {
            Graphics2D g = (Graphics2D) getGraphics();
            g.setColor(color);
            if (x != 0 && y != 0) {
                g.setStroke(new BasicStroke(lineWidth));
                g.drawLine(x, y, e.getX(), e.getY());

            }
            x = e.getX();
            y = e.getY();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = 0;
        y = 0;
    }
}
