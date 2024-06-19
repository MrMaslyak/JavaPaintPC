import javax.swing.*;
import java.awt.*;

public class CircleButton extends JButton { //ну этот класс гпт нарисовал :)
        private Color color;

        public CircleButton(Color color) {
            this.color = color;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(color.darker());
            } else {
                g.setColor(color);
            }
            g.fillOval(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(color.darker());
            g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        }

        @Override
        public boolean contains(int x, int y) {
            int radius = getWidth() / 2;
            return (x - radius) * (x - radius) + (y - radius) * (y - radius) <= radius * radius;
        }

    public Color getColor() {
        return color;
    }
}

