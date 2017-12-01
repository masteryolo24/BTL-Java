import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JPanel {

    private List<Person> persons;
    private List<Fruit> fruits;
    private Point2D offset;
    private static Font baseFont;
    private Random randomGenerator;
    private Person person;
    private Fruit bubble;
    private static final int W = 640;
    private static final int H = 480;

    private Paintable selectedShape;

    private List<Relationship> relationships;

    public Example() {
        persons = new ArrayList<>();  // Stores the person's names & coords
        fruits = new ArrayList<>(); // Stores the person's name and what fruits he sells & coords
        relationships = new ArrayList<>(25);

        randomGenerator = new Random();
        baseFont = new Font("Sans Serif", Font.BOLD, 12);

        String person1 = "Jimmy";
        String person2 = "Sally";


        String fruit1 = "Banana";
        String fruit2 = "Apple";
        String fruit3 = "Orange";
        String fruit4 = "Watermelon";
        String fruit5 = "Pineapple";
        String fruit6 = "Grapes";

        Person person = new Person(person1, 50, 50);
        addPerson(person);

        Fruit bubble = new Fruit(fruit1, baseFont, 150, 50);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit2, baseFont, 150, 100);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit3, baseFont, 150, 150);
        addFruit(bubble);
        relate(person, bubble);

        person = new Person(person2, 50, 150);
        addPerson(person);

        bubble = new Fruit(fruit4, baseFont, 150, 200);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit5, baseFont, 150, 250);
        addFruit(bubble);
        relate(person, bubble);
        bubble = new Fruit(fruit6, baseFont, 150, 300);
        addFruit(bubble);
        relate(person, bubble);

        this.setFont(baseFont);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Paintable p : getShapes()) {
                    if (p.contains(e.getPoint())) {
                        // Selected
                        selectedShape = p;
                        offset = new Point2D.Double(e.getX() - p.getBounds().getX(), e.getY() - p.getBounds().getY());
                        break;
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                selectedShape = null;
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedShape != null) {

                    Point2D p = new Point2D.Double(e.getX() - offset.getX(), e.getY() - offset.getX());

                    selectedShape.moveTo(p);
                }
                repaint();
            }
        });
    }

    protected List<Paintable> getShapes() {
        ArrayList<Paintable> shapes = new ArrayList<>(fruits);
        shapes.addAll(persons);
        return shapes;
    }

    public void addPerson(Person person) {
        persons.add(person);
        repaint();
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        for (Relationship relationship : relationships) {

            Point2D p1 = new Point2D.Double(relationship.getParent().getBounds().getCenterX(), relationship.getParent().getBounds().getCenterY());
            Point2D p2 = new Point2D.Double(relationship.getChild().getBounds().getCenterX(), relationship.getChild().getBounds().getCenterY());

            g2.draw(new Line2D.Double(p1, p2));

        }

        for (Person p : persons) {
            p.paint(this, g2);
        }
        for (Fruit f : fruits) {
            f.paint(this, g2);
        }

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.add(new Example());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    protected void relate(Person person, Fruit bubble) {
        relationships.add(new Relationship(person, bubble));
    }

    public class Relationship {

        private Paintable parent;
        private Paintable child;

        public Relationship(Paintable parent, Paintable child) {
            this.parent = parent;
            this.child = child;
        }

        public Paintable getChild() {
            return child;
        }

        public Paintable getParent() {
            return parent;
        }

    }

    public interface Paintable {

        public void paint(JComponent parent, Graphics2D g2d);

        public boolean contains(Point p);

        public void moveTo(Point2D p);

        public Rectangle2D getBounds();

    }

    public class Fruit implements Paintable {

        private static final long serialVersionUID = 1L;
        String fruit;
        Font font;

        private Ellipse2D bounds;

        public Fruit(String fruit, Font font, int x, int y) {
            this.fruit = fruit;
            this.font = font;
            bounds = new Ellipse2D.Double(x, y, 40, 90);
        }

        public String getFruit() {
            return fruit;
        }

        @Override
        public boolean contains(Point p) {
            return bounds.contains(p);
        }

        @Override
        public void moveTo(Point2D p) {
            bounds = new Ellipse2D.Double(p.getX(), p.getY(), 40, 90);
        }

        @Override
        public void paint(JComponent parent, Graphics2D g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(font);
            FontMetrics fm = g2.getFontMetrics();
            int height = fm.getHeight();
            int width = fm.stringWidth(fruit);

            g2.setColor(Color.WHITE);
            g2.fill(bounds);
            g2.setColor(Color.BLACK);
            g2.draw(bounds);

            double centreX = bounds.getX() + bounds.getWidth() / 2d;
            double centreY = bounds.getY() + bounds.getHeight() / 2d;
            g2.drawString(fruit, (int) (centreX - width / 2), (int) (centreY + height / 4));

            g2.dispose();
        }

        @Override
        public Rectangle2D getBounds() {
            return bounds.getBounds2D();
        }

    }

    public class Person implements Paintable {

        String person;
        private Rectangle2D bounds;

        public Person(String person, int x, int y) {
            this.person = person;
            bounds = new Rectangle2D.Double(x, y, 40, 90);
        }

        @Override
        public void paint(JComponent parent, Graphics2D g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.translate(bounds.getX(), bounds.getY());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawOval(0, 0, 20, 20); // head
            g2.drawLine(10, 20, 10, 50); // bodbounds.getY()
            g2.drawLine(10, 20, 25, 40); // right hand
            g2.drawLine(10, 20, 0 - 5, 40); // left hand
            g2.drawLine(10, 50, 0 - 5, 70); // left leg
            g2.drawLine(10, 50, 25, 70); // right leg
            g2.drawString(person, 0 - 15, 85);
            g2.dispose();
        }

        public String getPerson() {
            return person;
        }

        @Override
        public boolean contains(Point p) {
            return bounds.contains(p);
        }

        @Override
        public void moveTo(Point2D p) {
            bounds = new Rectangle2D.Double(p.getX(), p.getY(), 40, 90);
        }

        @Override
        public Rectangle2D getBounds() {
            return bounds.getBounds2D();
        }
    }

}