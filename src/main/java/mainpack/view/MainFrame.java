package mainpack.view;


import mainpack.domain.*;
import mainpack.service.NotebookService;
import mainpack.service.NotebookServiceImpl;
import mainpack.view.Table.CpuModel;
import mainpack.view.Table.MemoryModel;
import mainpack.view.Table.NotebookModel;
import mainpack.view.Table.VendorModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by admin on 30.12.2014.
 */
@Component
public class MainFrame extends JFrame {
    // logger
    Logger log = Logger.getLogger(MainFrame.class);
    File lofFile = new File("C:\\Users\\Андрей\\workspace\\proff19\\Andrey_Yashchuk\\log.txt");
/*    StringBuilder logger ;*/
    ArrayList<JLabel> logs = new ArrayList<>();
    //__________________________________


    private ShowListener showListener = new ShowListener();
    private Color color = new Color(115, 149,253);
    private Color color3 = new Color(200, 201, 253);
    private Color color2 = new Color(253, 238, 213);
    private Color color1 = new Color(255, 221, 226);
    private JPanel mainJPanel = new JPanel();




    private  NotebookService notebookService ;
    @Autowired
    public void setNotebookService(NotebookServiceImpl notebookService) {
        this.notebookService = notebookService;
    }

    // for JLabal satus
    String partGrean = "<html><font  color = #1E6D03>";
    String partRed = "\"<html><font  color = #CE0606>";
    String part2 = "</font>";


    // for containCreateJPanels and createJPanels
    private java.util.List<Vendor> vendorsList;
    private java.util.List<CPU> cpuList;
    private java.util.List<Memory> memoryList;
    private java.util.List<Notebook> notebookList;
    private java.util.List<Store> storeList;

    // for containUpdateJPanels and updateJPanels
    private java.util.List<Integer> id;
/*    private java.util.List<MyEntity> entity;*/

    // main JPanel
    private BorderLayout mainLayout = new BorderLayout();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel centerPanel = new JPanel();





    // North JPanel________________________________________________________
    Font northFont = new Font( "Calibri", Font.BOLD, 20);
    private JLabel title = new JLabel("Notebook Store");
    ///////////////////////////////////////////////////////////////////////






    // South JPanel________________________________________________________
    //Blackadder ITC
    //Bradley Hand ITC
    Font southFont = new Font( "Blackadder ITC", Font.PLAIN, 20);
    Font southFont1 = new Font( "Calibri", Font.PLAIN, 20);
    private JProgressBar progressBar = new JProgressBar();
    private JLabel state = new JLabel("State: ");
    private JLabel developer = new JLabel("@ Developer by Andrew Yashchuk");
    ///////////////////////////////////////////////////////////////////////




    // Center JPanel_______________________________________________________
    Font tableFont = new Font( "Times New Roman", Font.PLAIN, 18);
    private JTable table = new JTable() ;
    private   JScrollPane scrollPane = new JScrollPane(table);
    ///////////////////////////////////////////////////////////////////////





    // East JPanel_________________________________________________________
    private JPanel ManipulationPanel = new JPanel();
    private JPanel ShowPanel = new JPanel();
    public JFrame createFrame = new JFrame();
    private JPanel showPanelTabel = new JPanel();
/*    static ShowListener showListener = new ShowListener();*/
    private String [] selsect = {"<html><font  color = #061584>Vendor</font>","<html><font  color = #06847A>CPU</font>","<html><font  color = #0C8406>Memory</font>","<html><font  color = #847C06>Notebook</font>","<html><font color = #06BCBA>Sale</font>","<html><font  color = #840608>Store</font>"};
    private JComboBox comboBox = new JComboBox(selsect);
    private JButton create = new JButton("Create");
    private JButton update = new JButton("Update");
    private JButton logfile = new JButton("Show log file");
    private JButton btn1 = new JButton("Show linked table:");
    private JButton btn2 = new JButton("Show notebooks by portion");
    private JButton btn3 = new JButton("Show notebooks by amount");
    private JButton btn4 = new JButton("Show notebooks by cpu vendor");
    private JButton btn5 = new JButton("Show notebooks from store");
    private JButton btn6 = new JButton("Show notebooks store present");
    private JButton btn7 = new JButton("Show sales by days");
    //////////////////////////////////////////////////////////////////////////


    public MainFrame(){
        setTitle("Notebook Store");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("images/nt.png")));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        containMainJPanel();
        containJPanelNorth();
        containJPanelSouth();
        containJPanelCenter();
        containJPanelEast();
        setJMenuBar(new Menu());
        setLocation(200, 200);
        pack();
        log.info("Create frame");

    }

    private void readLogFile() {
        logs.clear();
        FileReader fr = null;
        try {
            fr = new FileReader(lofFile);
            Scanner scan = new Scanner(fr);
            while(scan.hasNext()){
                String s = scan.nextLine();
                logs.add(new JLabel(s));
            }
        } catch (FileNotFoundException e) {
           /* e.printStackTrace();*/
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
        System.out.println(logs.size());
    }

    private void containMainJPanel() {
        mainJPanel.setBackground(color2);
        mainJPanel.setLayout(new BorderLayout());
        add(westPanel, BorderLayout.WEST);
        add(eastPanel, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }


    private void containJPanelWest(){

    }

    private void containJPanelNorth(){
        title.setFont(northFont);
        northPanel.add(title);
    }

    private void containJPanelSouth(){
        southPanel.setBackground(color1);
        southPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        state.setFont(southFont1);
        developer.setFont(southFont);
        developer.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
        // progressBar.setSize(300,40);
        southPanel.setLayout(new BorderLayout());
        southPanel.add(state, BorderLayout.NORTH);
        southPanel.add(developer, BorderLayout.SOUTH);
        southPanel.add(progressBar, BorderLayout.CENTER);
        progressBar.setIndeterminate(false);
    }

    private void containJPanelCenter(){
        /*table.setFillsViewportHeight(true);*/
        table.setFont(tableFont);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new LineBorder(Color.getHSBColor(113, 197, 253), 4));
        centerPanel.add(scrollPane);
    }

    private void containJPanelEast(){
        eastPanel.setBackground(color3);
        containManipulationJPanel();
        eastPanel.setBackground(color);
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(ManipulationPanel, BorderLayout.NORTH);
        eastPanel.add(ShowPanel, BorderLayout.CENTER);
    }
    private void containManipulationJPanel(){
        ShowPanel.setBackground(color2);
        containShowPanel();
        ManipulationPanel.setLayout(new BorderLayout());
        ManipulationPanel.setBorder(new TitledBorder("Manipulation"));
        ManipulationPanel.add(create, BorderLayout.NORTH);
        ManipulationPanel.add(update, BorderLayout.CENTER);
        ManipulationPanel.add(comboBox, BorderLayout.SOUTH);

        create.addActionListener(showListener);
        update.addActionListener(showListener);
    }

    private void containShowPanel(){
        ShowPanel.setBackground(color3);
        containShowPanelTabel();
        ShowPanel.setLayout(new BorderLayout());
        ShowPanel.setBorder(new TitledBorder("Show"));


        ShowPanel.add(showPanelTabel, BorderLayout.NORTH);
        logfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ShowPanel.add(logfile, BorderLayout.SOUTH);
        logfile.addActionListener(showListener);




    }

    private void containShowPanelTabel(){
        showPanelTabel.setLayout(new GridLayout(7,1));
        showPanelTabel.add(btn1);
        //  add(manipulationjComboBox);
        showPanelTabel.add(btn2);
        showPanelTabel.add(btn3);
        showPanelTabel.add(btn4);
        showPanelTabel.add(btn5);
        showPanelTabel.add(btn6);
        showPanelTabel.add(btn7);

        btn1.addActionListener(showListener);
        btn2.addActionListener(showListener);
        btn3.addActionListener(showListener);
        btn4.addActionListener(showListener);
        btn5.addActionListener(showListener);
        btn6.addActionListener(showListener);
        btn7.addActionListener(showListener);

    }

    public void createFrame(JPanel jPanel, String title){
        jPanel.setBackground(color2);
        createFrame.setBackground(color);
        createFrame.setContentPane(jPanel);
        createFrame.setVisible(true);
        createFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //create.pack();
        createFrame.setTitle(title);
        createFrame.setResizable(false);
        createFrame.setLocationRelativeTo(null);
        createFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                progressBar.setIndeterminate(false);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                progressBar.setIndeterminate(false);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }


     class Menu extends JMenuBar{
        public Menu( ){
            //створюємо рядок меню
            //додаємо рядок меню у фрейм

            //Меню "Файл"
            JMenu fileMenu = new JMenu("File");
            add(fileMenu);
            //додаємо пункти в меню файл
            JMenuItem openItem = new JMenuItem ("Open", new ImageIcon("C:\\Users\\Андрей\\workspace\\proff19\\Andrey_Yashchuk\\src\\images\\Open.png"));
            fileMenu.add(openItem);
            //додаємо розділювач
            fileMenu.addSeparator();


            JMenuItem saveItem = new JMenuItem ("Save", new ImageIcon("C:\\Users\\Андрей\\workspace\\proff19\\Andrey_Yashchuk\\src\\images\\Save.png"));
            fileMenu.add(saveItem);

            //створити меню "закрити" в якому поряд з написом буде зображення
            JMenuItem closeItem = new JMenuItem ("Close", new ImageIcon("C:\\Users\\Андрей\\workspace\\proff19\\Andrey_Yashchuk\\src\\images\\CloseIcon.png"));
            fileMenu.add(closeItem);
            //додаємо обробник подій використавши безіменний внутрішній клас
            closeItem.addActionListener(new ActionListener( ) {
                @Override
                public void actionPerformed(ActionEvent e) { System.exit(0); }
            });


            // додаємо гарячу клавіші Ctrl-X до пункту "Закрити"
            closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));

            // меню "Вигляд"
            JMenu viewMenu = new JMenu("View");
            add(viewMenu);

            // меню "Допомога"
            JMenu helpMenu = new JMenu("Help");
            add(helpMenu);
            // можна використати метод add()
            // для додавання пунктів в меню зразу ж при створенні
            JMenuItem helpItem = helpMenu.add("Help");
            JMenuItem aboutItem = helpMenu.add("About");
        }
    }




    // containCreateJPanel____________________________________________________________________________
    public JPanel containCreateJPanelVendor(String entity){
        JLabel jLabel;
        JButton create = new JButton("Create");
        JTextField jtf = new JTextField(20);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(new JPanel().add(jLabel), BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        JPanel jpCenter = new JPanel();
        jpCenter.add(new JLabel("Enter Vendor`s name: "));
        jpCenter.add(jtf);
        jPanel.add(jpCenter, BorderLayout.CENTER);
        createFrame.setSize(250,120);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                System.out.println(jtf.getText());
                notebookService.createVendor(jtf.getText());
                state.setText(partGrean+"State: vendor is create!"+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containCreateJPanelCPU(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Create");
        JPanel center = new JPanel();
        JTextField fre = new JTextField(10);
        JTextField model = new JTextField(10);
        JComboBox vendor ;
        vendor = new JComboBox<>(createVendorsMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(3, 2));
        center.add(new JLabel("Enter CPU`s freq.:"));
        center.add(fre);
        center.add(new JLabel("Enter CPU`s model:"));
        center.add(model);
        center.add(new JLabel("Select CPU`s Vendor:"));
        center.add(vendor);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(300,150);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                int freq = Integer.parseInt(fre.getText());
                String CPUmoldel = model.getText();
                Vendor thisVendor = vendorsList.get(vendor.getSelectedIndex());
                notebookService.createCPU(thisVendor,CPUmoldel,freq);
                state.setText("Status: CPU is create");
                state.setText(partGrean+"State: cpu is create!"+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containCreateJPanelMemory(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Create");
        JPanel center = new JPanel();
        JTextField jtfHdd = new JTextField(10);
        JTextField jtfModel = new JTextField(10);
        JComboBox vendor ;
        vendor = new JComboBox<String>(createVendorsMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(3, 2));
        center.add(new JLabel("Enter Memory`s HDD capecity:"));
        center.add(jtfHdd);
        center.add(new JLabel("Enter Memory`s model:"));
        center.add(jtfModel);
        center.add(new JLabel("Select Memory`s Vendor:"));
        center.add(vendor);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(350,150);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                int hdd = Integer.parseInt(jtfHdd.getText());
                String model = jtfModel.getText();
                Vendor thisVendor = vendorsList.get(vendor.getSelectedIndex());
                notebookService.createMemory(thisVendor,hdd,model);
                state.setText(partGrean+"State: memory is create!"+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containCreateJPanelNotebook(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Create");
        JPanel center = new JPanel();
        JTextField jtfModel = new JTextField(10);
        JTextField jtfDate = new JTextField(10);
        JComboBox <String> vendor = new JComboBox(createVendorsMas());
        JComboBox memory  = new JComboBox(createMemoryMas());
        JComboBox cpu  = new JComboBox(createCpuMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(5, 2));
        center.add(new JLabel("Enter Notebook`s model:"));
        center.add(jtfModel);
        center.add(new JLabel("Enter Date of manufacture:"));
        center.add(jtfDate);
        center.add(new JLabel("Select Notebook`s Vendor:"));
        center.add(vendor);
        center.add(new JLabel("Select Notebook`s CPU:"));
        center.add(cpu);
        center.add(new JLabel("Select Notebook`s Memory:"));
        center.add(memory);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(400,200);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                String notebookModel = jtfModel.getText();
                String dateOfManufacture = jtfDate.getText();
                Vendor thisVendor = vendorsList.get(vendor.getSelectedIndex());
                CPU thisCpu = cpuList.get(cpu.getSelectedIndex());
                Memory thisMemory = memoryList.get(memory.getSelectedIndex());
                notebookService.createNotebook(thisVendor,notebookModel,dateOfManufacture,thisCpu,thisMemory);
                state.setText(partGrean+"State: notebook is create!"+ part2);
            }
        });
        return jPanel;
    }


    public JPanel containCreateJPanelSales(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Create");
        JPanel center = new JPanel();
        JTextField jtfAmaunt = new JTextField(10);
        JTextField jtfSold = new JTextField(10);
        JTextField jtDate = new JTextField(10);
        JComboBox notebook = new JComboBox<String>(createNotebookMas());
        JComboBox store  = new JComboBox<String>(createStoreMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(5, 2));
        center.add(new JLabel("Enter Sale`s amount"));
        center.add(jtfAmaunt);
        center.add(new JLabel("Enter Sale`s sold Notebook:"));
        center.add(jtfSold);
        center.add(new JLabel("Enter Sale`s Date:"));
        center.add(jtDate);
        center.add(new JLabel("Select Sale`s Notebook:"));
        center.add(notebook);
        center.add(new JLabel("Select Sale`s Store:"));
        center.add(store);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(375,200);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                int soldNotebook = Integer.parseInt(jtfSold.getText());
                int amount = Integer.parseInt(jtfAmaunt.getText());
                String date = jtDate.getText();
                Notebook thisNotebook = notebookList.get(notebook.getSelectedIndex());
                Store thisStore = storeList.get(store.getSelectedIndex());
                notebookService.sale(thisStore,date,thisNotebook,new Long(soldNotebook),amount);
                state.setText(partGrean+"State: sale is create!"+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containCreateJPanelStore(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Create");
        JPanel center = new JPanel();
        JTextField jtfAmount = new JTextField(10);
        JTextField jtfPrice  =  new JTextField(10);
        JComboBox notebook = new JComboBox<String>(createNotebookMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(3, 2));
        center.add(new JLabel("Enter Store`s amount"));
        center.add(jtfAmount);
        center.add(new JLabel("Enter Store`s price:"));
        center.add(jtfPrice);
        center.add(new JLabel("Select Store`s Notebook:"));
        center.add(notebook);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(350,150);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                int amount = Integer.parseInt(jtfAmount.getText());
                int price = Integer.parseInt(jtfPrice.getText());
                Notebook thisNotebook = notebookList.get(notebook.getSelectedIndex());
                notebookService.receive(thisNotebook,amount,price);
                state.setText(partGrean+"State: store is create!"+ part2);
            }
        });
        return jPanel;
    }

    private String [] createVendorsMas(){
        vendorsList = notebookService.getVendorList();
        String [] mas = new String[vendorsList.size()];
        for(int i=0;i<mas.length;i++){
            mas[i] = vendorsList.get(i).getName();
        }
        return mas;
    }
    private String [] createCpuMas(){
        cpuList = notebookService.getCPUList();
        String [] mas = new String[cpuList.size()];
        for(int i=0;i<mas.length;i++){
            mas[i] = cpuList.get(i).getModel();
        }
        return mas;
    }
    private String [] createMemoryMas(){
        memoryList = notebookService.getMemoryList();
        if(memoryList != null){
            String [] mas = new String[memoryList.size()];
            for(int i=0;i<mas.length;i++){
                mas[i] = memoryList.get(i).getModel();
            }
            return mas;
        }else state.setText(partRed+"State: Entity not created..."+part2);
        return null;

    }

    private String [] createNotebookMas(){
        notebookList = notebookService.getNotebooksList();
        if(notebookList != null){
            String [] mas = new String[notebookList.size()];
            for(int i=0;i<mas.length;i++){
                mas[i] = notebookList.get(i).getModel();
            }
            return mas;
        }else state.setText(partRed+"State: Entity not created..."+part2);


        return null;
    }

    private String [] createStoreMas(){
        storeList = notebookService.getStoreList();
        if(storeList != null){
            String [] mas = new String[storeList.size()];
            for(int i=0;i<mas.length;i++){
                mas[i] = ""+storeList.get(i).getId();
            }
            return mas;
        }else{
            state.setText(partRed+"State: Entity not created..."+part2);
        }

        return null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // containUpdateJPanel_______________________________________________________________________________________________________
    public JPanel containUpdateJPanelVendor(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JPanel center = new JPanel();
        JButton create = new JButton("Update");
        JTextField jtf = new JTextField(20);
        createVendorsMas();
        List<GetIdtable> entityList = (List)notebookService.getVendorList();
        JComboBox id = new JComboBox<Integer>(createIdMas(entityList));
        center.setLayout(new GridLayout(4, 2));
        center.add(new JLabel("Select Vendor`s id:"));
        center.add(id);
        center.add(new JLabel("Enter new Vendor`s name:"));
        center.add(jtf);
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(new JPanel().add(jLabel), BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(210,170);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                Vendor vendor = vendorsList.get(id.getSelectedIndex());
                vendor.setName(jtf.getText());
                notebookService.updateVendor(vendor);
                state.setText(partGrean+"State: vendor is update..."+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containUpdateJPanelCPU(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Update");
        JPanel center = new JPanel();
        JTextField fre = new JTextField(10);
        JTextField model = new JTextField(10);
        createCpuMas();
        createVendorsMas();
        JComboBox id = new JComboBox<Integer>(createIdMas((List)notebookService.getCPUList()));
        JComboBox vendor = new JComboBox<String>(createVendorsMas());
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(4, 2));
        center.add(new JLabel("Select CPU`s id:"));
        center.add(id);
        center.add(new JLabel("Enter new CPU`s freq.:"));
        center.add(fre);
        center.add(new JLabel("Enter new CPU`s model:"));
        center.add(model);
        center.add(new JLabel("Select new CPU`s Vendor:"));
        center.add(vendor);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(300,175);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                CPU cpu = cpuList.get(id.getSelectedIndex());
                Vendor vendor1 = vendorsList.get(vendor.getSelectedIndex());
                cpu.setVendor(vendor1);
                cpu.setFrequency(Integer.parseInt(fre.getText()));
                cpu.setModel(model.getText());
                notebookService.updateCPU(cpu);
                state.setText(partGrean+"State: CPU is update..."+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containUpdateJPanelMemory(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Update");
        JPanel center = new JPanel();
        JTextField jtfHdd = new JTextField(10);
        JTextField jtfModel = new JTextField(10);
        createMemoryMas();
        createVendorsMas();
        JComboBox vendor = new JComboBox<String>(createVendorsMas());
        JComboBox id = new JComboBox<Integer>(createIdMas((List) notebookService.getMemoryList()));
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(4, 2));
        center.add(new JLabel("Select new Memory`s id:"));
        center.add(id);
        center.add(new JLabel("Enter new Memory`s HDD capecity:"));
        center.add(jtfHdd);
        center.add(new JLabel("Enter new Memory`s model:"));
        center.add(jtfModel);
        center.add(new JLabel("Select new Memory`s Vendor:"));
        center.add(vendor);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(350,170);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                Memory memory = memoryList.get(id.getSelectedIndex());
                Vendor vendor1 = vendorsList.get(vendor.getSelectedIndex());
                memory.setModel(jtfModel.getText());
                memory.setHdd(Integer.parseInt(jtfHdd.getText()));
                memory.setVendor(vendor1);
                notebookService.updateMemory(memory);
                state.setText(partGrean+"State: memory is update..."+ part2);
            }
        });
        return jPanel;
    }

    public JPanel containUpdateJPanelNotebook(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Update");
        JPanel center = new JPanel();
        createVendorsMas();
        createMemoryMas();
        createCpuMas();
        createNotebookMas();
        JTextField jtfModel = new JTextField(10);
        JTextField jtfDate = new JTextField(10);
        JComboBox vendor = new JComboBox<String>(createVendorsMas());
        JComboBox memory = new JComboBox<String>(createMemoryMas());
        JComboBox cpu = new JComboBox<String>(createCpuMas());
        JComboBox id = new JComboBox<Integer>(createIdMas((List) notebookService.getNotebooksList()));
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(6, 2));
        center.add(new JLabel("Select new Notebook`s id:"));
        center.add(id);
        center.add(new JLabel("Enter Notebook`s model:"));
        center.add(jtfModel);
        center.add(new JLabel("Enter Date of manufacture:"));
        center.add(jtfDate);
        center.add(new JLabel("Select new Notebook`s Vendor:"));
        center.add(vendor);
        center.add(new JLabel("Select new Notebook`s CPU:"));
        center.add(cpu);
        center.add(new JLabel("Select new Notebook`s Memory:"));
        center.add(memory);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(400,220);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);
                Vendor vendor1 = vendorsList.get(vendor.getSelectedIndex());
                Memory memory1 = memoryList.get(memory.getSelectedIndex());
                CPU cpu1 = cpuList.get(cpu.getSelectedIndex());
                Notebook notebook = notebookList.get(id.getSelectedIndex());
                notebook.setVendor(vendor1);
                notebook.setCpu(cpu1);
                notebook.setMemory(memory1);
                notebook.setModel(jtfModel.getText());
                notebook.setDate(jtfDate.getText());
                notebookService.updateNotebook(notebook);
                state.setText(partGrean+"State: notebook is update..."+ part2);
            }
        });
        return jPanel;
    }


    public JPanel containUpdateSalesJPanel(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Update");
        JPanel center = new JPanel();
        JTextField jtfAmaunt = new JTextField(10);
        JTextField jtfSold = new JTextField(10);
        JTextField jtDate = new JTextField(10);
        createNotebookMas();
        createStoreMas();
        JComboBox notebook = new JComboBox<String>(createNotebookMas());
        JComboBox store  = new JComboBox<String>(createStoreMas());
        JComboBox id = new JComboBox<Integer>(createIdMas((List)notebookService.getSalesList()));
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(create, BorderLayout.SOUTH);
        center.setLayout(new GridLayout(6, 2));
        center.add(new JLabel("Select new Sale`s id:"));
        center.add(id);
        center.add(new JLabel("Enter new Sale`s amount"));
        center.add(jtfAmaunt);
        center.add(new JLabel("Enter new Sale`s sold Notebook:"));
        center.add(jtfSold);
        center.add(new JLabel("Enter new Sale`s Date:"));
        center.add(jtDate);
        center.add(new JLabel("Select new Sale`s Notebook:"));
        center.add(notebook);
        center.add(new JLabel("Select new Sale`s Store:"));
        center.add(store);
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(375,220);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);

            }
        });
        return jPanel;
    }

    public JPanel containUpdateStoreJPanel(String entity){
        JPanel jPanel = new JPanel();
        JLabel jLabel;
        JButton create = new JButton("Update");
        JPanel center = new JPanel();
        JTextField jtfAmount = new JTextField(10);
        JTextField jtfPrice  =  new JTextField(10);

        JComboBox notebook = new JComboBox<String>(createNotebookMas());
        JComboBox id = new JComboBox<Integer>(createIdMas((List) notebookService.getStoreList()));
        jPanel.setLayout(new BorderLayout());
        jLabel = new JLabel(entity);
        jPanel.add(jLabel,BorderLayout.NORTH);
        jPanel.add(create,BorderLayout.SOUTH);
        center.setLayout(new GridLayout(4, 2));
        center.add(new JLabel("Select Store`s id:"));
        center.add(id);
        center.add(new JLabel("Enter Store`s amount"));
        center.add(jtfAmount);
        center.add(new JLabel("Enter Store`s price:"));
        center.add(jtfPrice);
/*        center.add(new JLabel("Select Store`s Notebook:"));
        center.add(notebook);*/
        jPanel.add(center, BorderLayout.CENTER);
        createFrame.setSize(350,170);
        progressBar.setIndeterminate(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setIndeterminate(false);
                createFrame.setVisible(false);

            }
        });
        return jPanel;
    }

    public Integer [] createIdMas(java.util.List<GetIdtable> entity){
        Integer [] mas = null;
        try{
            mas = new Integer[entity.size()];
            for(int i =0;i<entity.size();i++){
                mas[i] = entity.get(i).getIdEntity().intValue();
            }
        }catch (NullPointerException e){
            state.setText(partRed+"State: Entity not created..."+part2);
        }
        return mas;
    }
    ////////////////////////////////////////////////////////////////////////////////


    // showPanel ___________________________________________________________________
    public JPanel containShowByAmountJPanel(){
        JPanel jPanel = new JPanel();
        JTextField jtf = new JTextField(10);
        JButton show = new JButton("Show");
        jPanel.add(new JLabel("Show notebook by amount"));
        jPanel.add(new JLabel("Enter amount: "));
        jPanel.add(jtf);
        jPanel.add(show);
        createFrame.setSize(230,110);
        progressBar.setIndeterminate(true);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jPanel;
    }

    public JPanel containShowByPortionJPanel(){
        JPanel jPanel = new JPanel();
        JTextField jtf = new JTextField(10);
        JButton show = new JButton("Show");
            //  setLayout(new BorderLayout());
        jPanel.add(new JLabel("Show notebook by portion")/*, BorderLayout.NORTH*/);
        jPanel.add(new JLabel("Enter portin: ")/*, BorderLayout.WEST*/);
        jPanel.add(jtf/*, BorderLayout.EAST*/);
        jPanel.add(show/*, BorderLayout.SOUTH*/);
        createFrame.setSize(230,110);
        progressBar.setIndeterminate(true);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jPanel;
    }

    public JPanel containShowByCpuVendorJPanel() {
        JPanel jPanel = new JPanel();
        JComboBox vendor = new JComboBox<String>(createCpuVendorMas());
        JButton show = new JButton("Show");
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new JLabel("Show notebook by vendor"), BorderLayout.NORTH);
        jPanel.add(new JLabel("Select CPU`s vendor: "), BorderLayout.WEST);
        jPanel.add(vendor, BorderLayout.CENTER);
        jPanel.add(show, BorderLayout.SOUTH);
        createFrame.setSize(230,100);
        progressBar.setIndeterminate(true);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jPanel;
    }



    public JPanel containShowByVendorJPanel() {
        JPanel jPanel = new JPanel();
        JComboBox vendor = new JComboBox<String>(createCpuVendorMas());
        JButton show = new JButton("Show");
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new JLabel("Show notebook by vendor"), BorderLayout.NORTH);
        jPanel.add(new JLabel("Select CPU`s vendor: "), BorderLayout.WEST);
        jPanel.add(vendor, BorderLayout.CENTER);
        jPanel.add(show, BorderLayout.SOUTH);
        createFrame.setSize(230,100);
        progressBar.setIndeterminate(true);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jPanel;
    }



    private String [] createCpuVendorMas(){
        String [] mas = null;
        try{
            cpuList = notebookService.getCPUList();
            vendorsList = new ArrayList<>();
            for(int i=0; i<cpuList.size();i++ ){
                vendorsList.add(cpuList.get(i).getVendor());
            }
            mas = new String[vendorsList.size()];
            for(int i=0;i<mas.length;i++){
                mas[i] = vendorsList.get(i).getName();
            }
        }catch (NullPointerException e){
            state.setText(partRed+"State: Entity Cpu not created..."+part2);
        }
        return mas;
    }





    public class ShowListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //  JPanelSouth.state.setText("Create");
            if(e.getSource() == create){
                String entity = (String) comboBox.getSelectedItem();
                if(entity.equals(selsect[0])){
                    System.out.println(selsect[0]);
                    createFrame(containCreateJPanelVendor(entity),"Create");
                }if(entity.equals(selsect[1])){
                    System.out.println(selsect[1]);
                    createFrame(containCreateJPanelCPU(entity),"Create");
                }if(entity.equals(selsect[2])){
                    System.out.println(selsect[2]);
                    createFrame(containCreateJPanelMemory(entity),"Create");
                }if(entity.equals(selsect[3])){
                    System.out.println(selsect[3]);
                    createFrame(containCreateJPanelNotebook(entity),"Create");
                }if(entity.equals(selsect[4])) {
                    System.out.println(selsect[4]);
                    createFrame(containCreateJPanelSales(entity),"Create");
                }if(entity.equals(selsect[5])) {
                    System.out.println(selsect[5]);
                    createFrame(containCreateJPanelStore(entity),"Create");
                }
            }
            if(e.getSource() == update){
                String entity = (String) comboBox.getSelectedItem();
                if(entity.equals(selsect[0])){
                    System.out.println(selsect[0]);
                    createFrame(containUpdateJPanelVendor(entity),"Update");
                }if(entity.equals(selsect[1])){
                    System.out.println(selsect[1]);
                    createFrame(containUpdateJPanelCPU(entity),"Update");
                }if(entity.equals(selsect[2])){
                    System.out.println(selsect[2]);
                    createFrame(containUpdateJPanelMemory(entity),"Update");
                }if(entity.equals(selsect[3])){
                    System.out.println(selsect[3]);
                    createFrame(containUpdateJPanelNotebook(entity),"Update");
                }if(entity.equals(selsect[4])) {
                    System.out.println(selsect[4]);
                    createFrame(containUpdateSalesJPanel(entity),"Update");
                }if(entity.equals(selsect[5])) {
                    System.out.println(selsect[5]);
                    createFrame(containUpdateStoreJPanel(entity),"Remove from stor");
                }

            }
            if(e.getSource() == btn1){
                String entity = (String) comboBox.getSelectedItem();
                if(entity.equals(selsect[0])){
                    System.out.println(selsect[0]);
                    showVendorTable();
                }if(entity.equals(selsect[1])){
                    System.out.println(selsect[1]);
                    showCpuTable();
                }if(entity.equals(selsect[2])){
                    System.out.println(selsect[2]);
                    showMemoryTable();
                }if(entity.equals(selsect[3])){
                    System.out.println(selsect[3]);
                    showNotebookTable();

                }if(entity.equals(selsect[4])) {
                    System.out.println(selsect[4]);

                }if(entity.equals(selsect[5])) {
                    System.out.println(selsect[5]);

                }
            }
            if(e.getSource() == btn2){
                createFrame(containShowByPortionJPanel(),"ShowByPortion");
            }
            if(e.getSource() == btn3){
                createFrame(containShowByAmountJPanel(),"ShowByAmount");
            }
            if(e.getSource() == btn4){
                createFrame(containShowByCpuVendorJPanel(),"ShowByVendor");
            }
            if(e.getSource() == logfile){
                showLogFile();
            }

        }
    }

    private void showLogFile() {
        readLogFile();
        JScrollPane scrollPane1 = new JScrollPane();
        for(int i=0;i<logs.size();i++){
            scrollPane1.add(logs.get(i));
        }
        centerPanel.removeAll();
        centerPanel.add(scrollPane1);
        centerPanel.revalidate();
        this.pack();
    }

    private void showVendorTable() {
        table = new JTable(new VendorModel(notebookService.getVendorList()));
        table.setFont(tableFont);
        centerPanel.removeAll();
        centerPanel.add(new JScrollPane(table));
        centerPanel.revalidate();
        this.pack();
    }
    private void showMemoryTable() {
        table = new JTable(new MemoryModel(notebookService.getMemoryList()));
        table.setFont(tableFont);
        centerPanel.removeAll();
        centerPanel.add(new JScrollPane(table));
        centerPanel.revalidate();
        this.pack();
    }
    private void showCpuTable() {
        table = new JTable(new CpuModel(notebookService.getCPUList()));
        table.setFont(tableFont);
        centerPanel.removeAll();
        centerPanel.add(new JScrollPane(table));
        centerPanel.revalidate();
        this.pack();
    }
    private void showNotebookTable() {
        table = new JTable(new NotebookModel(notebookService.getNotebooksList()));
        table.setFont(new Font("Times New Roman", Font.PLAIN, tableFont.getSize()-5));
        centerPanel.removeAll();
        centerPanel.add(new JScrollPane(table));
        centerPanel.revalidate();
        this.pack();
    }

}
