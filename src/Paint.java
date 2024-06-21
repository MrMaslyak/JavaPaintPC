
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

public class Paint extends JFrame implements ActionListener, MouseMotionListener {
    Color color;
    Color color2;
    Color color3;
    private int x;
    private int y;
    private CircleButton bigButton;
    private boolean isDragging;
    private int lineWidth;
    private ArrayList<JLabel> points;
    private int xCoordinat;
    private int yCoordinat;
    private int fontSize;
    private JLabel textValueCoordinatX;
    private JLabel textValueCoordinatY;
    private JScrollBar scrollBarCoordinatX;
    private JScrollBar scrollBarCoordinatY;
    private boolean isDrawingCircle;
    private boolean isDrawingRectangle;
    private JPanel panelBrush;
    private JPanel panelKey;
    JLabel labelForMassege;

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public int getyCoordinat() {
        return this.yCoordinat;
    }

    public void setyCoordinat(int yCoordinat) {
        this.yCoordinat = yCoordinat;
    }

    public int getxCoordinat() {
        return this.xCoordinat;
    }

    public void setxCoordinat(int xCoordinat) {
        this.xCoordinat = xCoordinat;
    }

    Paint() {
        this.color = Color.BLACK;
        this.color2 = Color.BLACK;
        this.color3 = Color.BLACK;
        this.isDragging = false;
        this.lineWidth = 1;
        this.points = new ArrayList<>();
        this.isDrawingCircle = false;
        this.isDrawingRectangle = false;
        this.labelForMassege = new JLabel();
        this.setTitle("Paint");
        this.setSize(1350, 750);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setForeground(Color.white);
        this.setLayout((LayoutManager) null);
        this.addMouseMotionListener(this);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), 150);
        this.isDragging = true;
        panel.setBackground(Color.decode("#E6E6FA"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setLayout((LayoutManager) null);
        panel.setOpaque(true);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Paint.this.isDragging = true;
            }

            public void mouseExited(MouseEvent e) {
                Paint.this.isDragging = false;
            }
        });
        this.add(panel);
        this.panelKey = new JPanel();
        this.panelKey.setBounds(50, 20, 150, 100);
        this.panelKey.setBackground(Color.decode("#E6E6FA"));
        this.panelKey.setBorder(BorderFactory.createLineBorder(this.color3, 1));
        this.panelKey.setLayout((LayoutManager) null);
        this.panelKey.setOpaque(true);
        this.add(this.panelKey);
        panel.add(this.panelKey);
        JLabel textInstruments = new JLabel("Instruments");
        textInstruments.setFont(new Font("Arial", Font.ITALIC, 15));
        textInstruments.setBounds(85, 120, 80, 30);
        this.add(textInstruments);
        panel.add(textInstruments);
        Button bFill = this.createButtonKey("F", 30, 10);
        bFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.getContentPane().setBackground(Paint.this.bigButton.getColor());
                Paint.this.getContentPane().setForeground(Paint.this.bigButton.getColor());
                Paint.this.repaint();
            }
        });
        this.add(bFill);
        panel.add(bFill);
        this.panelKey.add(bFill);
        Button bLastik = this.createButtonKey("L", 90, 10);
        bLastik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.color = new Color(237, 237, 237);
            }
        });
        this.add(bLastik);
        panel.add(bLastik);
        this.panelKey.add(bLastik);
        Button bPencil = this.createButtonKey("P", 60, 50);
        bPencil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.color = Color.BLACK;
            }
        });
        this.add(bPencil);
        panel.add(bPencil);
        this.panelKey.add(bPencil);
        final JTextField textField = new JTextField();
        textField.setBounds(230, 22, 150, 75);
        this.add(textField);
        panel.add(textField);
        JLabel message = new JLabel("Text");
        message.setFont(new Font("Arial", Font.ITALIC, 17));
        message.setBounds(290, 93, 80, 23);
        this.add(message);
        panel.add(message);
        JLabel textCoordinatX = new JLabel("X");
        textCoordinatX.setFont(new Font("Arial", Font.ITALIC, 12));
        textCoordinatX.setBounds(238, 133, 20, 20);
        this.add(textCoordinatX);
        panel.add(textCoordinatX);
        this.textValueCoordinatX = new JLabel("0");
        this.textValueCoordinatX.setFont(new Font("Arial", Font.ITALIC, 23));
        this.textValueCoordinatX.setBounds(232, 119, 40, 20);
        this.add(this.textValueCoordinatX);
        panel.add(this.textValueCoordinatX);
        this.scrollBarCoordinatX = new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 999);
        this.scrollBarCoordinatX.setBounds(230, 98, 40, 20);
        this.scrollBarCoordinatX.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Paint.this.xCoordinat = e.getValue();
                Paint.this.textValueCoordinatX.setText(String.valueOf(Paint.this.xCoordinat));
            }
        });
        this.add(this.scrollBarCoordinatX);
        panel.add(this.scrollBarCoordinatX);
        JLabel textCoordinatY = new JLabel("Y");
        textCoordinatY.setFont(new Font("Arial", Font.ITALIC, 12));
        textCoordinatY.setBounds(360, 133, 20, 20);
        this.add(textCoordinatY);
        panel.add(textCoordinatY);
        this.textValueCoordinatY = new JLabel("0");
        this.textValueCoordinatY.setFont(new Font("Arial", Font.ITALIC, 23));
        this.textValueCoordinatY.setBounds(340, 119, 40, 20);
        this.add(this.textValueCoordinatY);
        panel.add(this.textValueCoordinatY);
        this.scrollBarCoordinatY = new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 999);
        this.scrollBarCoordinatY.setBounds(340, 98, 40, 20);
        this.scrollBarCoordinatY.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Paint.this.yCoordinat = e.getValue();
                Paint.this.textValueCoordinatY.setText(String.valueOf(Paint.this.yCoordinat));
            }
        });
        this.add(this.scrollBarCoordinatY);
        panel.add(this.scrollBarCoordinatY);
        Button bText = new Button("Send");
        bText.setBounds(275, 117, 60, 30);
        bText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.setText("");
                if (!text.isEmpty()) {
                    Paint.this.labelForMassege = new JLabel();
                    Paint.this.labelForMassege.setBounds(Paint.this.xCoordinat, Paint.this.yCoordinat + 160, 300, 40);
                    Paint.this.labelForMassege.setFont(new Font("Arial", Font.ITALIC, 22));
                    Paint.this.labelForMassege.setText(text);
                    Paint.this.getContentPane().add(Paint.this.labelForMassege);
                    Paint.this.points.add(Paint.this.labelForMassege);
                    Paint.this.xCoordinat = 0;
                    Paint.this.textValueCoordinatX.setText("0");
                    Paint.this.textValueCoordinatY.setText("0");
                    Paint.this.scrollBarCoordinatX.setValue(0);
                    Paint.this.scrollBarCoordinatY.setValue(0);
                    Paint.this.repaint();
                }
            }
        });
        this.add(bText);
        panel.add(bText);
        final JLabel textValue = new JLabel("0");
        textValue.setFont(new Font("Arial", Font.ITALIC, 30));
        textValue.setBounds(385, 60, 55, 30);
        this.add(textValue);
        panel.add(textValue);
        JScrollBar scrollBar = new JScrollBar(Adjustable.VERTICAL, 0, 0, 0, 99);
        scrollBar.setBounds(420, 20, 20, 100);
        this.isDragging = true;
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Paint.this.lineWidth = e.getValue();
                Paint.this.setLineWidth(Paint.this.lineWidth);
                textValue.setText(String.valueOf(Paint.this.getLineWidth()));
            }
        });
        this.add(scrollBar);
        panel.add(scrollBar);
        JLabel textValueValue = new JLabel("Value");
        textValueValue.setFont(new Font("Arial", Font.ITALIC, 15));
        textValueValue.setBounds(412, 115, 100, 30);
        this.add(textValueValue);
        panel.add(textValueValue);
        JLabel textColor = new JLabel("Color");
        textColor.setFont(new Font("Arial", Font.ITALIC, 15));
        textColor.setBounds(690, 95, 100, 30);
        this.add(textColor);
        panel.add(textColor);
        JLabel textClear = new JLabel("Clear");
        textClear.setFont(new Font("Arial", Font.ITALIC, 15));
        textClear.setBounds(912, 95, 100, 30);
        this.add(textClear);
        panel.add(textClear);
        this.bigButton = this.createBigButton();
        this.add(this.bigButton);
        panel.add(this.bigButton);
        CircleButton bIndigo = this.createButton(Color.decode("#4B0082"), 630, 25);
        this.add(bIndigo);
        panel.add(bIndigo);
        CircleButton bMediumPurple = this.createButton(Color.decode("#9370DB"), 630, 60);
        this.add(bMediumPurple);
        panel.add(bMediumPurple);
        CircleButton bDeepPink = this.createButton(Color.decode("#ff1493"), 665, 25);
        this.add(bDeepPink);
        panel.add(bDeepPink);
        CircleButton bHotPink = this.createButton(Color.decode("#ff69b4"), 665, 60);
        this.add(bHotPink);
        panel.add(bHotPink);
        CircleButton bRed = this.createButton(Color.RED, 700, 25);
        this.add(bRed);
        panel.add(bRed);
        CircleButton bDarkRed = this.createButton(new Color(137, 8, 28), 700, 60);
        this.add(bDarkRed);
        panel.add(bDarkRed);
        CircleButton bBlue = this.createButton(Color.BLUE, 735, 25);
        this.add(bBlue);
        panel.add(bBlue);
        CircleButton bLBlue = this.createButton(Color.decode("#00ffe6"), 735, 60);
        this.add(bLBlue);
        panel.add(bLBlue);
        CircleButton bGreen = this.createButton(Color.GREEN, 770, 25);
        this.add(bGreen);
        panel.add(bGreen);
        CircleButton bDarkGreen = this.createButton(new Color(27, 132, 7), 770, 60);
        this.add(bDarkGreen);
        panel.add(bDarkGreen);
        CircleButton bPink = this.createButton(Color.PINK, 805, 25);
        this.add(bPink);
        panel.add(bPink);
        CircleButton bPurple = this.createButton(Color.MAGENTA, 805, 60);
        this.add(bPurple);
        panel.add(bPurple);
        CircleButton bGrey = this.createButton(Color.GRAY, 840, 25);
        this.add(bGrey);
        panel.add(bGrey);
        CircleButton bLightGrey = this.createButton(Color.LIGHT_GRAY, 840, 60);
        this.add(bLightGrey);
        panel.add(bLightGrey);
        CircleButton bOrange = this.createButton(new Color(253, 176, 10), 875, 25);
        this.add(bOrange);
        panel.add(bOrange);
        CircleButton bYellow = this.createButton(Color.YELLOW, 875, 60);
        this.add(bYellow);
        panel.add(bYellow);
        CircleButton bBlack = this.createButton(Color.BLACK, 910, 25);
        this.add(bBlack);
        panel.add(bBlack);
        CircleButton bWhite = this.createButton(Color.WHITE, 910, 60);
        this.add(bWhite);
        panel.add(bWhite);
        CircleButton bBrown = this.createButton(Color.decode("#964B00"), 945, 25);
        this.add(bBrown);
        panel.add(bBrown);
        CircleButton bAntiqueWhite = this.createButton(Color.decode("#FAEBD7"), 945, 60);
        this.add(bAntiqueWhite);
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

        this.panelBrush = new JPanel();
        this.panelBrush.setBounds(1000, 10, 150, 130);
        this.panelBrush.setBorder(BorderFactory.createLineBorder(this.color2, 1));
        this.panelBrush.setLayout((LayoutManager) null);
        this.panelBrush.setOpaque(true);
        this.add(this.panelBrush);
        panel.add(this.panelBrush);
        Button changedBrush = new Button("Brush Circle");
        changedBrush.setBounds(20, 10, 110, 35);
        changedBrush.setFont(new Font("Arial", Font.BOLD, 15));
        changedBrush.setForeground(Color.BLACK);
        changedBrush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.isDrawingCircle = true;
                Paint.this.isDrawingRectangle = false;
            }
        });
        this.panelBrush.add(changedBrush);
        Button changedBrushLine = new Button("Brush Line");
        changedBrushLine.setBounds(20, 46, 110, 35);
        changedBrushLine.setFont(new Font("Arial", Font.BOLD, 15));
        changedBrushLine.setForeground(Color.BLACK);
        changedBrushLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.isDrawingCircle = false;
                Paint.this.isDrawingRectangle = false;
            }
        });
        this.panelBrush.add(changedBrushLine);
        Button changedBrushRectangle = new Button("Brush Rectan");
        changedBrushRectangle.setBounds(20, 80, 110, 35);
        changedBrushRectangle.setFont(new Font("Arial", Font.BOLD, 15));
        changedBrushRectangle.setForeground(Color.BLACK);
        changedBrushRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paint.this.isDrawingRectangle = true;
                Paint.this.isDrawingCircle = false;
            }
        });
        this.panelBrush.add(changedBrushRectangle);
        final JLabel labelVolumeText = new JLabel("0");
        labelVolumeText.setBounds(340, 3, 35, 20);
        labelVolumeText.setFont(new Font("Arial", Font.ITALIC, 20));
        this.isDragging = true;
        this.add(labelVolumeText);
        panel.add(labelVolumeText);
        JScrollBar scrollBarVolumeText = new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 99);
        scrollBarVolumeText.setBounds(235, 3, 100, 20);
        this.isDragging = true;
        scrollBarVolumeText.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Paint.this.fontSize = e.getValue();
                labelVolumeText.setText(String.valueOf(Paint.this.fontSize));
                Paint.this.labelForMassege.setFont(new Font("Arial", Font.PLAIN, Paint.this.fontSize));
                Paint.this.updateLabelHeight(Paint.this.labelForMassege, Paint.this.fontSize);
            }
        });
        this.add(scrollBarVolumeText);
        panel.add(scrollBarVolumeText);
        JLabel labelSizeText = new JLabel("Size text");
        labelSizeText.setBounds(370, 3, 60, 20);
        labelSizeText.setFont(new Font("Arial", Font.ITALIC, 15));
        this.isDragging = true;
        this.add(labelSizeText);
        panel.add(labelSizeText);
        this.setVisible(true);
    }

    private void updateLabelHeight(JLabel label, int fontSize) {
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        label.setFont(font);
        FontMetrics metrics = label.getFontMetrics(font);
        int height = metrics.getHeight();
        label.setSize(label.getWidth(), height);
    }

    private CircleButton createButton(final Color colorB, int x, int y) {
        this.isDragging = true;
        CircleButton button = new CircleButton(colorB);
        button.setBounds(x - 90, y, 30, 30);
        button.addActionListener(this);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Paint.this.color = colorB;
                Paint.this.bigButton.setColor(Paint.this.color);
                Paint.this.bigButton.repaint();
                Paint.this.color2 = Paint.this.bigButton.getColor();
                Paint.this.panelBrush.setBorder(BorderFactory.createLineBorder(Paint.this.color2, 1));
                Paint.this.panelBrush.repaint();
                Paint.this.color3 = Paint.this.bigButton.getColor();
                Paint.this.panelKey.setBorder(BorderFactory.createLineBorder(Paint.this.color3, 1));
                Paint.this.panelKey.repaint();
            }
        });
        return button;
    }

    private Button createButtonKey(String name, int x, int y) {
        this.isDragging = true;
        Button button = new Button(name);
        button.setBounds(x, y, 30, 30);
        button.addActionListener(this);
        button.setBackground(Color.decode("#D3D3D3"));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Pacifico", Font.ITALIC, 15));
        return button;
    }

    private CircleButton createBigButton() {
        this.isDragging = true;
        CircleButton button = new CircleButton(Color.BLACK);
        button.setBounds(475, 25, 60, 60);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if (!this.isDragging) {
            Graphics2D g = (Graphics2D) this.getGraphics();
            g.setColor(this.color);
            if (this.x != 0 && this.y != 0 && this.isDrawingCircle && !this.isDrawingRectangle) {
                g.setStroke(new BasicStroke((float) this.lineWidth));
                g.drawOval(this.x, this.y, e.getX(), e.getY());
            }

            if (this.x != 0 && this.y != 0 && !this.isDrawingCircle && !this.isDrawingRectangle) {
                g.setStroke(new BasicStroke((float) this.lineWidth));
                g.drawLine(this.x, this.y, e.getX(), e.getY());
            }

            if (this.x != 0 && this.y != 0 && !this.isDrawingCircle && this.isDrawingRectangle) {
                g.setStroke(new BasicStroke((float) this.lineWidth));
                g.drawRect(this.x, this.y, e.getX(), e.getY());
            }

            this.x = e.getX();
            this.y = e.getY();
        }

    }

    public void mouseMoved(MouseEvent e) {
        this.x = 0;
        this.y = 0;
    }
}