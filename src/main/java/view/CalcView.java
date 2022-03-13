package view;
import model.CalcModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Clasa pentru implementarea interfetei grafice
public class CalcView extends JFrame {
    // Variabilele instanta sunt private

    // Modelul calculatorului
    private CalcModel model;

    // Panou ce contine toate componentele
    private JPanel contentPanel = new JPanel();

    // Etichete
    private JLabel titleLabel = new JLabel("Polynomial Calculator");
    private JLabel pLabel = new JLabel("P(X) = ");
    private JLabel qLabel = new JLabel("Q(X) = ");
    private JLabel resLabel = new JLabel("Result");

    // Campuri de test
    private JTextField pTextField = new JTextField();
    private JTextField qTextField = new JTextField();
    private JTextField resTextField = new JTextField();

    // Butoane
    private JButton integrateBtn = new JButton("∫");
    private JButton difBtn = new JButton("d/dX");
    private JButton addBtn = new JButton("+");
    private JButton subBtn = new JButton("-");
    private JButton mulBtn = new JButton("×");
    private JButton divBtn = new JButton("/");
    private JButton clearBtn = new JButton("Clear all");

    // Constructor - se seteaza elementele de design (aspectul GUI)
    public CalcView(CalcModel model){
        this.model = model;
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(550, 450));
        this.setLocationRelativeTo(null);
        this.setContentPane(contentPanel);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(209, 255, 216));

        titleLabel.setFont(new Font("Cambria Math", Font.BOLD, 35));
        titleLabel.setForeground(new Color(168, 50,     100));
        titleLabel.setAlignmentX(0.5f);
        contentPanel.add(titleLabel);

        JPanel polyPanel = new JPanel();
        polyPanel.setBackground(new Color(209, 255, 216));

        JPanel pPanel = new JPanel();
        pPanel.setLayout(new BoxLayout(pPanel, BoxLayout.Y_AXIS));
        JPanel inputP = new JPanel();
        inputP.setBackground(new Color(209, 255, 216));
        JLabel firstPol = new JLabel("First polynomial");
        firstPol.setFont(new Font("Cambria Math", Font.BOLD, 25));
        firstPol.setForeground(new Color(168, 50,     100));
        firstPol.setAlignmentX(0.5f);
        pPanel.add(firstPol);
        pLabel.setFont(new Font("Cambria Math", Font.BOLD, 23));
        pLabel.setForeground(new Color(168, 50,     100));
        pPanel.setBackground(new Color(209, 255, 216));
        pTextField.setBackground(new Color(209, 243, 255));
        pTextField.setPreferredSize(new Dimension(2 * this.getWidth() / 3 + 40, 40));
        pTextField.setForeground(new Color(168, 50,     100));
        pTextField.setFont(new Font("Cambria Math", Font.BOLD, 20));
        inputP.add(pLabel);
        inputP.add(pTextField);
        pPanel.add(inputP);

        JPanel qPanel = new JPanel();
        qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.Y_AXIS));
        JPanel inputQ = new JPanel();
        inputQ.setBackground(new Color(209, 255, 216));
        JLabel secondPol = new JLabel("Second polynomial");
        secondPol.setFont(new Font("Cambria Math", Font.BOLD, 25));
        secondPol.setForeground(new Color(168, 50,     100));
        secondPol.setAlignmentX(0.5f);
        qPanel.add(secondPol);
        qLabel.setFont(new Font("Cambria Math", Font.BOLD, 23));
        qLabel.setForeground(new Color(168, 50,     100));
        qPanel.setBackground(new Color(209, 255, 216));
        qTextField.setBackground(new Color(209, 243, 255));
        qTextField.setPreferredSize(new Dimension(2 * this.getWidth() / 3 + 40, 40));
        qTextField.setForeground(new Color(168, 50,     100));
        qTextField.setFont(new Font("Cambria Math", Font.BOLD, 20));
        inputQ.add(qLabel);
        inputQ.add(qTextField);
        qPanel.add(inputQ);


        JPanel resPanel = new JPanel();
        resPanel.setBackground(new Color(209, 255, 216));
        resPanel.setLayout(new BoxLayout(resPanel, BoxLayout.Y_AXIS));
        resLabel.setFont(new Font("Cambria Math", Font.BOLD, 25));
        resLabel.setForeground(new Color(168, 50,     100));
        resLabel.setAlignmentX(0.5f);
        resPanel.add(resLabel);
        JPanel resClr = new JPanel();
        resClr.setLayout(new BoxLayout(resClr, BoxLayout.X_AXIS));
        resClr.setBackground(new Color(209, 255, 216));
        resTextField.setBackground(new Color(209, 243, 255));
        resTextField.setPreferredSize(new Dimension(2 * this.getWidth() / 3, 40));
        resTextField.setForeground(new Color(168, 50,100));
        resTextField.setFont(new Font("Cambria Math", Font.BOLD, 20));
        resTextField.setEditable(false);
        clearBtn.setBackground(new Color(168, 50,     100));
        clearBtn.setForeground(new Color(209, 255, 216));
        clearBtn.setFont(new Font("Cambria Math", Font.BOLD, 22));
        resClr.add(resTextField);
        resClr.add(clearBtn);
        resPanel.add(resClr);

        polyPanel.add(pPanel);
        polyPanel.add(qPanel);
        polyPanel.add(resPanel);
        contentPanel.add(polyPanel);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setPreferredSize(new Dimension(this.getWidth(), -100));
        btnsPanel.setLayout(new GridLayout(1,0));
        addBtn.setForeground(new Color(168, 50,     100));
        addBtn.setFont(new Font("Cambria Math", Font.BOLD, 50));
        addBtn.setBackground(new Color(209, 243, 255));
        subBtn.setForeground(new Color(168, 50,     100));
        subBtn.setFont(new Font("Cambria Math", Font.BOLD, 50));
        subBtn.setBackground(new Color(209, 243, 255));
        mulBtn.setForeground(new Color(168, 50,     100));
        mulBtn.setFont(new Font("Cambria Math", Font.BOLD, 50));
        mulBtn.setBackground(new Color(209, 243, 255));
        divBtn.setForeground(new Color(168, 50,     100));
        divBtn.setFont(new Font("Cambria Math", Font.BOLD, 50));
        divBtn.setBackground(new Color(209, 243, 255));
        difBtn.setForeground(new Color(168, 50,     100));
        difBtn.setFont(new Font("Cambria Math", Font.BOLD, 24));
        difBtn.setBackground(new Color(209, 243, 255));
        integrateBtn.setForeground(new Color(168, 50,     100));
        integrateBtn.setFont(new Font("Cambria Math", Font.BOLD, 50));
        integrateBtn.setBackground(new Color(209, 243, 255));

        btnsPanel.add(addBtn);
        btnsPanel.add(subBtn);
        btnsPanel.add(mulBtn);
        btnsPanel.add(divBtn);
        btnsPanel.add(difBtn);
        btnsPanel.add(integrateBtn);
        this.contentPanel.add(btnsPanel);
    }

    // Metoda folosita la afisarea ferestrelor de eroare cu mesaje corespunzatoare
    public void showError(String errMessage){
        JOptionPane.showMessageDialog(this, errMessage);
    }

    // Resetarea GUI - golirea text field-urilor
    public void reset(){
        pTextField.setText("");
        qTextField.setText("");
        resTextField.setText("");
    }

    // Resetarea campului pentru rezultat in vederea efectuarii unei noi operatii cu operanzii deja introdusi
    public void resetResult(){
        this.resTextField.setText("");
    }

    // Metode de set si get
    public String getInputP(){
        return pTextField.getText();
    }

    public String getInputQ(){
        return qTextField.getText();
    }

    public void setResult(String res){
        resTextField.setText(res);
    }

    public void setPTextField(String s) { pTextField.setText(s); }

    // Metode pentru adaugarea listenerilor
    public void addAddListener(ActionListener addListener){
        this.addBtn.addActionListener(addListener);
    }

    public void addSubListener(ActionListener subListener){
        this.subBtn.addActionListener(subListener);
    }

    public void addMulListener(ActionListener mulListener){
        this.mulBtn.addActionListener(mulListener);
    }

    public void addDivListener(ActionListener divListener){
        this.divBtn.addActionListener(divListener);
    }

    public void addDifListener(ActionListener difListener){
        this.difBtn.addActionListener(difListener);
    }

    public void addIntListener(ActionListener intListener){
        this.integrateBtn.addActionListener(intListener);
    }

    public void addClearListener(ActionListener clearListener){
        this.clearBtn.addActionListener(clearListener);
    }


}
