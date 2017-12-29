/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationlaborantin;

import EJB.EJBAnalysesRemote;
import entities.Analyses;
import static java.lang.Integer.parseInt;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author tibha
 */
public class Laborantin  extends javax.swing.JFrame implements MessageListener{

    @Resource(mappedName = "jms/myQueue")
    private static Queue myQueue;
    @EJB
    private static EJBAnalysesRemote ejb_Analyses;
    @Resource(mappedName = "jms/myQueueFactory")
    private static ConnectionFactory myQueueFactory;
    
    private static Connection connection = null;
    private static Session session = null;
    private static MessageConsumer consumer;
    private LinkedList list;
    private String AnalyseEnCours = "";
    private String ValeurAnalyseEnCours = "";
    private int numAnalyse;
    /**
     * Creates new form Test
     */
    public Laborantin() {
        initComponents();
        try
        {
            System.out.println(ejb_Analyses.sayHello("Labo"));
            list = new LinkedList();
            connection = myQueueFactory.createConnection();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            connection.start();
            consumer = session.createConsumer(myQueue);
            consumer.setMessageListener(this);             
        } catch (JMSException ex) {
            Logger.getLogger(Laborantin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldLeucocytes = new javax.swing.JTextField();
        jTextFieldHematies = new javax.swing.JTextField();
        jTextFieldHemoglobine = new javax.swing.JTextField();
        jTextFieldVGM = new javax.swing.JTextField();
        jTextFieldHematocrite = new javax.swing.JTextField();
        jTextFieldCCMH = new javax.swing.JTextField();
        jTextFieldTCMH = new javax.swing.JTextField();
        jTextFieldRDW = new javax.swing.JTextField();
        jLabelLeucocytes = new javax.swing.JLabel();
        jLabelHematies = new javax.swing.JLabel();
        jLabelHemoglobine = new javax.swing.JLabel();
        jLabelVGM = new javax.swing.JLabel();
        jLabelHematocrite = new javax.swing.JLabel();
        jLabelCCMH = new javax.swing.JLabel();
        jLabelTCMH = new javax.swing.JLabel();
        jLabelRDW = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelAnalyse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelLeucocytes.setText("Leucocytes");

        jLabelHematies.setText("Hématies");

        jLabelHemoglobine.setText("Hémoglobine");

        jLabelVGM.setText("V.G.M");

        jLabelHematocrite.setText("Hématocrite");

        jLabelCCMH.setText("C.C.M.H");

        jLabelTCMH.setText("T.C.M.H");

        jLabelRDW.setText("RDW");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Résultats de l'analyse");

        jButton1.setText("Publier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelAnalyse.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAnalyse.setText("Pas d'analyse en cours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAnalyse)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLeucocytes)
                            .addComponent(jLabelHematies)
                            .addComponent(jLabelHemoglobine)
                            .addComponent(jLabelVGM))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldHemoglobine, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldHematies, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLeucocytes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVGM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelRDW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldRDW, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTCMH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldTCMH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCCMH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCCMH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHematocrite)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldHematocrite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(jLabelAnalyse)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLeucocytes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLeucocytes)
                    .addComponent(jTextFieldHematocrite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHematocrite))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCCMH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldHematies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHematies)
                        .addComponent(jLabelCCMH)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHemoglobine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTCMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHemoglobine)
                    .addComponent(jLabelTCMH))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRDW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVGM)
                    .addComponent(jLabelRDW))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        list.remove(AnalyseEnCours);
        Analyses analyse = new Analyses();
        String tmp[];
        tmp=AnalyseEnCours.split("@@");
        analyse.setIdAnalyses(numAnalyse);
        analyse.setItem(tmp[1]);
        getTextField();
        analyse.setValeur(ValeurAnalyseEnCours);
        ejb_Analyses.AddAnalyse(analyse);
        if(AnalyseEnCours.contains("URGENT"))
        {
            ejb_Analyses.sendMessageTopic(analyse.getIdAnalyses().toString() + "@@" + analyse.getItem() + "@@" + analyse.getValeur(),false);
        }
        ejb_Analyses.sendMessageTopic(analyse.getIdAnalyses().toString(),true);
        if(list.isEmpty())
        {
            AnalyseEnCours = "";
            ValeurAnalyseEnCours = "";
            setTextField();
            jLabelAnalyse.setText("Pas d'analyse en cours");
            jLabelAnalyse.setForeground(new java.awt.Color(255, 0, 0));
            jButton1.enable(false);
        }
        else
        {
            AnalyseEnCours = (String) list.getFirst();
            ValeurAnalyseEnCours = "";
            System.out.println(AnalyseEnCours);
            setTextField();
            jLabelAnalyse.setText("Analyse a faire");
            jLabelAnalyse.setForeground(new java.awt.Color(51, 51, 255));
            jButton1.enable(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Laborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laborantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laborantin().setVisible(true);
            }
        });
    }
    
    
    private void getTextField()
    {
            String txt = AnalyseEnCours;
            ValeurAnalyseEnCours = "";
            if(AnalyseEnCours.contains("Leucocytes"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldLeucocytes.getText()+"@";
            }
            if(AnalyseEnCours.contains("CCMH"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldCCMH.getText()+"@";
            }
            if(AnalyseEnCours.contains("Hematies"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldHematies.getText()+"@";
            }
            if(AnalyseEnCours.contains("Hematocrite"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldHematocrite.getText()+"@";
            }
            if(AnalyseEnCours.contains("Hemoglobine"))
            { 
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldHemoglobine.getText()+"@";
            }
            if(AnalyseEnCours.contains("RDW"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldRDW.getText()+"@";
            }
            if(AnalyseEnCours.contains("TCMH"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldTCMH.getText()+"@";
            }
            if(AnalyseEnCours.contains("VGM"))
            {
                ValeurAnalyseEnCours = ValeurAnalyseEnCours + jTextFieldVGM.getText()+"@";
            }
    }
    private void setTextField()
    {
            String txt = AnalyseEnCours;
            if(!txt.equals(""))
            {
                String tmp[];
                tmp=txt.split("@@");
                numAnalyse = parseInt(tmp[0]);
            }
            jTextFieldLeucocytes.setText("");
            jTextFieldHematies.setText("");
            jTextFieldCCMH.setText("");
            jTextFieldHematocrite.setText("");
            jTextFieldHemoglobine.setText("");
            jTextFieldRDW.setText("");
            jTextFieldTCMH.setText("");
            jTextFieldVGM.setText("");
            if(AnalyseEnCours.contains("Leucocytes"))
            {
                jTextFieldLeucocytes.enable(true);
                jLabelLeucocytes.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldLeucocytes.enable(false);
                jLabelLeucocytes.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("Hematies"))
            {
                jTextFieldHematies.enable(true);
                jLabelHematies.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldHematies.enable(false);
                jLabelHematies.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("CCMH"))
            {
                jTextFieldCCMH.enable(true);
                jLabelCCMH.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldCCMH.enable(false);
                jLabelCCMH.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("Hematocrite"))
            {
                jTextFieldHematocrite.enable(true);
                jLabelHematocrite.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldHematocrite.enable(false);
                jLabelHematocrite.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("Hemoglobine"))
            {
                jTextFieldHemoglobine.enable(true);
                jLabelHemoglobine.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldHemoglobine.enable(false);
                jLabelHemoglobine.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("RDW"))
            {
                jTextFieldRDW.enable(true);
                jLabelRDW.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldRDW.enable(false);
                jLabelRDW.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("TCMH"))
            {
                jTextFieldTCMH.enable(true);
                jLabelTCMH.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldTCMH.enable(false);
                jLabelTCMH.setForeground(new java.awt.Color(255, 0, 0));
            }
            if(AnalyseEnCours.contains("VGM"))
            {
                jTextFieldVGM.enable(true);
                jLabelVGM.setForeground(new java.awt.Color(51, 51, 255));
            }
            else
            {
                jTextFieldVGM.enable(false);
                jLabelVGM.setForeground(new java.awt.Color(255, 0, 0));
            }
    }

    @Override
    public void onMessage(Message message) {
        try
        {
            TextMessage tm = (TextMessage)message;
            System.out.println("Message = " + tm.getText());

            if(AnalyseEnCours.equals(""))
            {
                AnalyseEnCours = tm.getText();
                setTextField();
                jLabelAnalyse.setText("Analyse a faire");
                jLabelAnalyse.setForeground(new java.awt.Color(51, 51, 255));
                jButton1.enable(true);
            }
            if(tm.getText().contains("URGENT"))
            {
                list.addFirst(tm.getText());
            }
            else
                list.add(tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(Laborantin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAnalyse;
    private javax.swing.JLabel jLabelCCMH;
    private javax.swing.JLabel jLabelHematies;
    private javax.swing.JLabel jLabelHematocrite;
    private javax.swing.JLabel jLabelHemoglobine;
    private javax.swing.JLabel jLabelLeucocytes;
    private javax.swing.JLabel jLabelRDW;
    private javax.swing.JLabel jLabelTCMH;
    private javax.swing.JLabel jLabelVGM;
    private javax.swing.JTextField jTextFieldCCMH;
    private javax.swing.JTextField jTextFieldHematies;
    private javax.swing.JTextField jTextFieldHematocrite;
    private javax.swing.JTextField jTextFieldHemoglobine;
    private javax.swing.JTextField jTextFieldLeucocytes;
    private javax.swing.JTextField jTextFieldRDW;
    private javax.swing.JTextField jTextFieldTCMH;
    private javax.swing.JTextField jTextFieldVGM;
    // End of variables declaration//GEN-END:variables
}
