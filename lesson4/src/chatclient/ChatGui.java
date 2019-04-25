package chatclient;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.*;
public class ChatGui extends JFrame {

    public ChatGui() throws HeadlessException
    {
        setTitle("MyChat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        JPanel jPanel = new JPanel();
        JTextField tf = new JTextField(20);
      // отправка сообщения при нажатии на Enter
        tf.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
             if (e.getKeyCode()==KeyEvent.VK_ENTER){
                jTextArea.setText( jTextArea.getText()+"\n"+new Date().toString() + " : "+ tf.getText());
                tf.setText("");}
            }

        });
        JButton send = new JButton("Отправить");
        // отправка сообщения при нажатии на кнопку "Отправить"
        send.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jTextArea.setText( jTextArea.getText()+"\n"+new Date().toString() + " : "+ tf.getText());
                tf.setText("");
            }
        });

        jPanel.add(BorderLayout.EAST,tf);
        jPanel.add(BorderLayout.WEST,send);

        getContentPane().add(BorderLayout.CENTER, jTextArea);
        getContentPane().add(BorderLayout.SOUTH, jPanel);

        setVisible(true);


    }
}
