package com.chat.gui;

import com.chat.networking.MessageListener;
import com.chat.networking.MessageTransmitter;
import com.chat.networking.WritableGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by egorka on 23.08.16.
 */
public class HomePage extends javax.swing.JFrame implements WritableGUI {
    private JTextField ipTextField;
    private JTextField targetPort;
    private JButton listenButton;
    private JTextArea chat;
    private JTextField message;
    private JButton sendButton;
    private JButton recivePort;

    @SuppressWarnings("unchecked")
    MessageListener listener;

    public HomePage() {
        listenButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                listener = new MessageListener(this, Integer.parseInt(recivePort.getText()));
                listener.start();
            }
        });
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageTransmitter transmitter = new MessageTransmitter(message.getText(), ipTextField.getText(), Integer.parseInt(targetPort.getText()));
                transmitter.start();
            }
        });
    }

    public void write(String s) {
        chat.append(s + System.lineSeparator());
    }


}
