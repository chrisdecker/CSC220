Chapter 17
==========
1.  How do you create a button labeled OK? How do you change text on a
    button? How do you set an icon, pressed icon, rollover icon in a
    button?
    
    .. code-block:: java
        
        import javax.swing.JButton;
        import javax.swing.ImageIcon;
        
        JButton btnOk = new JButton("OK");
        
        btnOk.setText("Not Ok");
        
        btnOk.setIcon(new ImageIcon("images/icon.png"))
        btnOk.setRolloverIcon(new ImageIcon("images/hover.png"))
        btnOk.setPressedIcon(new ImageIcon("images/click.png"))

2.  Given a ``JButton`` object ``jbtOk``, write statements to set the
    button's foreground to red, background to yellow, mnemonic to 'K',
    tooltip text to "Click OK to proceed", horizontal alignment to
    ``RIGHT``, vertical alignment to ``BOTTOM``, horizontal text
    position to ``LEFT``, vertical text position to ``TOP`` and icon
    text gap to 5.
    
    .. code-block:: java
        
        import java.awt.Color;
        import java.awt.event.KeyEvent;
        
        jbtOk.setForeground(Color.RED);
        jbtOk.setBackground(Color.YELLOW);
        jbtOk.setMnemonic(KeyEvent.VK_K);
        jbtOk.setToolTipText("Click OK to proceed");
        jbtOk.setHorizontalAlignment(JButton.RIGHT_ALIGNMENT);
        jbtOk.setVerticalAlignment(JButton.BOTTOM_ALIGNMENT);
        jbtOk.setHorizontalTextPosition(JButton.LEFT_ALIGNMENT);
        jbtOk.setVerticalTextPosition(JButton.TOP_ALIGNMENT);
        jbtOk.setIconTextGap(5);

3.  How do you create a check box? How do you create a check box with
    the box checked initially? How do you determine whether a check box
    is selected?
    
    .. code-block:: java
        
        import javax.swing.JCheckBox;
        
        JRadioButton chkBox = new JRadioButton("Rad", true);
        
        JRadioButton.isSelected();

4.  How do you create a radio button? How do you create a radio button
    with the button selected initially? How do you create a radio button
    group? How do you determine whether a radio button is selected?
    
    .. code-block:: java
        
        import javax.swing.JRadioButton;
        
        JCheckBox chkBox = new JCheckBox("Chech", true);
        
        chkBox.isSelected();

5.  List at least five properties defined in the AbstractButton class.
    
    CONTENT_AREA_FILLED_CHANGED_PROPERTY 
        Identifies a change to having the button paint the content
        area.
    DISABLED_ICON_CHANGED_PROPERTY 
        Identifies a change to the icon used when the button has been
        disabled.
    DISABLED_SELECTED_ICON_CHANGED_PROPERTY 
        Identifies a change to the icon used when the button has been
        disabled and selected.
    FOCUS_PAINTED_CHANGED_PROPERTY 
        Identifies a change to having the border highlighted when
        focused, or not.
    HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY 
        Identifies a change in the button's horizontal alignment.

6.  How do you create a label named "Address"? How do you change the
    name on a label? How do you set an icon in a label?
    
    .. code-block:: java
        
        import javax.swing.JLabel;
        import javax.swing.ImageIcon;
        
        JLabel lblAddress = new JLabel("Address");
        
        lblAddress.setText("Not Address");
        
        lblAddress.setIcon(new ImageIcon("images/icon.png"))

7.  Given a ``JLabel`` object ``jlbMap``, write statements to set the
    label's foreground to red, background to yellow, mnemonic to 'K',
    tooltip text to "Click OK to proceed", horizontal alignment to
    ``RIGHT``, vertical alignment to ``BOTTOM``, horizontal text
    position to ``LEFT``, vertical text position to ``TOP`` and icon
    text gap to 5.
    
    .. code-block::
        
        import java.awt.Color;
        import java.awt.event.KeyEvent;
        
        jlbMap.setForeground(Color.RED);
        jlbMap.setBackground(Color.YELLOW);
        jlbMap.setMnemonic(KeyEvent.VK_K);
        jlbMap.setToolTipText("Click OK to proceed");
        jlbMap.setHorizontalAlignment(JLabel.RIGHT_ALIGNMENT);
        jlbMap.setVerticalAlignment(JLabel.BOTTOM_ALIGNMENT);
        jlbMap.setHorizontalTextPosition(JLabel.LEFT_ALIGNMENT);
        jlbMap.setVerticalTextPosition(JLabel.TOP_ALIGNMENT);
        jlbMap.setIconTextGap(5);

8.  How do you create a text field with ten columns and the default text
    "Welcome to Java"? How do you create write the code the check
    whether a text field is empty?
    
    .. code-block:: java
        
        import javax.swing.JTextField;
        
        JTextField txtBox = new JTextField("Welcome to Java");
        txtBox.setColumns(10);
        
        txtBox.getText().length();

9.  How do you create a text area with 10 rows and 20 columns? How do
    you insert three lines into the text area? How do you create a
    scrollable text area?
    
    .. code-block:: java
        
        import javax.swing.JScrollPane;
        import javax.swing.JTextArea;
        
        JTextArea txtArea = new JTextArea();
        txtArea.setColumns(20);
        txtArea.setRows(10);
        
        txtArea.replaceSelection("\n\n\n");
        
        JScrollPane scrlPane =new JScrollPane();
        scrlPane.add(txtArea);

10. How do you create a combo box, add three items to it, and retrieve
    a selected item?
    
    .. code-block:: java
        
        import javax.swing.JComboBox;
        
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Item 0");
        comboBox.addItem("Item 1");
        comboBox.addItem("Item 2");
        
        comboBox.getSelectedItem();

11. How do you create a list with an array of strings?
    
    .. code-block:: java
        
        import javax.swing.JList;
        
        String[] data = {"one", "two", "three", "five", "eight"};
        JList list = new JList(data);
        

12. How do you create a horizontal scrollbar? What event does a scroll
    bar fire?
    
    .. code-block:: java
        
        import javax.swing.JScrollBar;
        
        JScrollBar scrlBar = new JScrollBar(JScrollBar.HORIZONTAL);
    
    Scrollbars generate ``changeEvent``s, among others, such as
    mouse-wheels and key presses (space, arrow, page buttons, home,
    end, etc.)

13. How do you create a vertical slider? What event does a vertical
    slider fire?
    
    

14. Explain how to create and show multiple frames in an application.
    
    

