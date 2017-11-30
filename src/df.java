//public void render() {
//        g2D.setStroke(new BasicStroke(line_stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
//        g2D.setColor(new Color(0xFFF194));
//        g2D.fillRect(Xaxis,Yaxis,width,headerHeight+methodHeight+attributeHeight);
//        g2D.setColor(Color.BLACK);
//        g2D.drawRect(Xaxis,Yaxis,width,headerHeight+methodHeight+attributeHeight);
//
//        g2D.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
//        g2D.drawLine(Xaxis,Yaxis+headerHeight,Xaxis+width,Yaxis+headerHeight);
//        g2D.drawLine(Xaxis,Yaxis+headerHeight+attributeHeight,Xaxis+width,Yaxis+headerHeight+attributeHeight);
//        g2D.drawLine(Xaxis,Yaxis+headerHeight+attributeHeight+methodHeight,Xaxis+width,Yaxis+headerHeight+attributeHeight+methodHeight);
//
//        g2D.setFont(headerFont);
//        g2D.drawString(obj.getName(),Xaxis+(this.width-g2D.getFontMetrics().stringWidth(obj.getName()))/2,
//        Yaxis+g2D.getFontMetrics().charWidth('A')+line_spacing);
//
//        g2D.setFont(otherFont);
//        ArrayList<Element> listOfElement = obj.getListOfElement();
//        int addingSpace = headerHeight + line_spacing;
//        for (Element element : listOfElement) {
//
//        if (element instanceof Method) continue;
//
//        // Tao dau .... o duoi khi thu nho block
//        if (addingSpace + line_spacing*3/2 > this.getHeight()) {
//        String dotString = "";
//        while (g2D.getFontMetrics().stringWidth(dotString) < this.getWidth() - line_indent*16) dotString += '.';
//        g2D.drawString(dotString,Xaxis+line_indent*8,Yaxis+this.getHeight()-5);
//        return;
//        }
//        String printedString = element.getName()+" : "+element.getType();
//        printedString = minimizeString(printedString);
//        addingSpace += g2D.getFontMetrics().charWidth('A');
//
//        String accessLevel = element.getAccessLevel();
//        BufferedImage icon = null;
//        switch (accessLevel) {
//        case "public":
//        icon = imagePublic;
//        break;
//        case "private":
//        icon = imagePrivate;
//        break;
//        case "protected":
//        icon = imageProtected;
//        break;
//        case "no modifiers":
//        icon = imagePackage;
//        break;
//        }
//        g2D.drawImage(icon,Xaxis+line_indent,Yaxis+addingSpace-13,null);
//        g2D.drawString(printedString,Xaxis+line_indent+iconSize,Yaxis+addingSpace);
//        addingSpace += line_spacing;
//        }
//
//        addingSpace = headerHeight + attributeHeight + line_spacing;
//        for (Element element : listOfElement) {
//
//        if (element instanceof Attribute) continue;
//
//        if (addingSpace + line_spacing*3/2 > this.getHeight()) {
//        String dotString = "";
//        while (g2D.getFontMetrics().stringWidth(dotString) < this.getWidth() - line_indent*16) dotString += '.';
//        g2D.drawString(dotString,Xaxis+line_indent*8,Yaxis+this.getHeight()-5);
//        return;
//        }
//
//        String printedString = element.getName()+" : "+element.getType();
//        printedString = minimizeString(printedString);
//        addingSpace += g2D.getFontMetrics().charWidth('A');
//
//        String accessLevel = element.getAccessLevel();
//        //System.out.println(accessLevel);
//        BufferedImage icon = null;
//        switch (accessLevel) {
//        case "public":
//        icon = imagePublic;
//        break;
//        case "private":
//        icon = imagePrivate;
//        break;
//        case "protected":
//        icon = imageProtected;
//        break;
//        case "no modifiers":
//        icon = imagePackage;
//        break;
//        }
//        g2D.drawImage(icon,Xaxis+line_indent,Yaxis+addingSpace-13,null);
//        g2D.drawString(printedString,Xaxis+line_indent+iconSize,Yaxis+addingSpace);
//        addingSpace += line_spacing;
//        }
//        }