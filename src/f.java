//@SuppressWarnings("serial")
//class Diagram extends JPanel {
//    int panelWidth = 960;
//    int panelHeight = 720;
//    int lastMouseX = 0, lastMouseY = 0;
//    int imageX = 30, imageY = 30;
//    double scaleFactor = 1;
//
//    public Diagram() {
//        MouseMotionHandler mouseHandler = new MouseMotionHandler();
//        addMouseMotionListener(mouseHandler);
//        addMouseListener(mouseHandler);
//        addMouseWheelListener(mouseHandler);
//
//
//        //setSize(panelWidth,panelHeight);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension((int) (panelWidth), (int) (panelHeight));
//    }
//
//    @Override
////    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//
//        Graphics2D g2 = (Graphics2D) g;
//
//        g2.scale(scaleFactor,scaleFactor);
//
//        g2.fillRect(imageX,imageY,300,300);
//        g2.drawRect(imageX,imageY,300,300);
//    }
//
//    class MouseMotionHandler extends MouseMotionAdapter implements
//            MouseListener, MouseWheelListener {
//
//        public void mousePressed(MouseEvent e) {
//            lastMouseX = e.getX();
//            lastMouseY = e.getY();
//        }
//
//        public void mouseDragged(MouseEvent e) {
//            Rectangle rec = new Rectangle(imageX,imageY,300,300);
//
//            if (rec.contains(e.getX()/scaleFactor,e.getY()/scaleFactor)) {
//                int xDiff = e.getX() - lastMouseX;
//                int yDiff = e.getY() - lastMouseY;
//                imageX = imageX + (int) (xDiff / scaleFactor);
//                imageY = imageY + (int) (yDiff / scaleFactor);
//                lastMouseX = e.getX();
//                lastMouseY = e.getY();
//                panelWidth = Math.max(panelWidth, imageX + 300);
//                panelHeight = Math.max(panelWidth, imageY + 300);
//                //this.setPreferredSize(panelWidth,panelHeight);
//                repaint();
//            }
//        }
//
//        public void mouseWheelMoved(MouseWheelEvent e) {
//            int notches = e.getWheelRotation();
//            scaleFactor = scaleFactor + notches / 10.0;
//            if (scaleFactor < 0.5) {
//                //scaleFactor = 0.5;
//            } else if (scaleFactor > 3.0) {
//                scaleFactor = 3.0;
//            }
//            panelWidth*=scaleFactor;
//            panelHeight*=scaleFactor;
//            //this.setPreferredSize(panelWidth,panelHeight);
//            repaint();
//        }
//
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        public void mouseEntered(MouseEvent e) {
//        }
//
//        public void mouseExited(MouseEvent e) {
//        }
//
//        public void mouseClicked(MouseEvent e) {
//        }
//    }
//
//}