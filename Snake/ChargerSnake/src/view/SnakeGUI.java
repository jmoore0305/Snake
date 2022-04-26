/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Utility.Message;
import Utility.Observer;
import controller.SnakeController;
import controller.SnakeController.GameController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.SnakeModel;

/**
 *The SnakeGUI contains all of the objects that make up the view
 * for the entire program. Java swing was used in this program to implement
 * the view. It contains the one JFrame, four panels, and several
 * components which are broken out into multiple files in the view package.
 * It's main responsibility is to draw the various "Frames" of which there are
 * four. We have a "StartFrame", "GamePlayFrame", "PauseFrame", and
 * "LeaderBoardFrame". These methods are called when the model sends a message
 * which is evaluated with the update method implemented by the Observer interface.
 */
public class SnakeGUI implements Observer {

    private final JFrame window;
    private final JPanel GamePanel;
    private final JPanel MenuPanel;
    private final JButton startButton;
    private final JLabel chargerSnakeMess;
    private final JLabel enterNameMess;
    private final JTextField inputField;
    private final JButton pauseButton;
    private final JLabel scoreLabel;
    private final JLabel scoreLabelArea;
    private final JLabel pauseLabel;
    private final JButton resumeButton;
    private final JButton returnToStartButton;
    private final SnakeModel model;
    private final SnakeController controller;
    private final SnakeController.GameController gameController;

    /**
     * This constructor gets called at the start of the game. It makes reference
     * to the controller and model. In addition it initializes all of the elements
     * of the view that will be operated on. All of the components and two
     * of the panels are defined in other files in the view.
     * @param controller
     * @param model 
     */
    SnakeGUI(SnakeController controller, SnakeModel model) {
        
        this.model = model;
        
        model.attach(this);
        
        this.controller = controller;
        
        gameController = controller.new GameController();
        //initLocal
        window = new JFrame("Charger Snake");
        
      //  SnakeController.GameController gameController = controller.new GameController();
        
        controller.initController(model, this);

        GamePanel = new JPanel();

        MenuPanel = new JPanel();

        chargerSnakeMess = new ChargerSnakeComp().getChargerSnakeComp();

        enterNameMess = new MessLabelComp().getMessLabelComp();

        startButton = new StartButtonComp().getStartButtonComp();

        inputField = new InputFieldComp().getInputFieldComp();

        pauseButton = new PauseButtonComp().getPauseButtonComp();

        scoreLabel = new ScoreLabelComp().getScoreLabelComp();

        scoreLabelArea = new ScoreLabelAreaComp().getScoreLabelAreaComp();

        pauseLabel = new PauseLabelComp().getPauseLabelComp();

        resumeButton = new ResumeButtonComp().getResumeButtonComp();

        returnToStartButton = new ReturnStartComp().getReturnStartComp();

        
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //GamePanel
        GamePanel.setBackground(Color.black);

        GamePanel.setPreferredSize(new Dimension(500, 500));

        GamePanel.add(chargerSnakeMess);

        GamePanel.add(enterNameMess);

        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //MenuPanel
        MenuPanel.setBackground(Color.gray);

        MenuPanel.setPreferredSize(new Dimension(500, 100));

        MenuPanel.add(inputField);

        MenuPanel.add(startButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        startButton.addActionListener(controller);

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //Window
        window.add(GamePanel, BorderLayout.CENTER);

        window.add(MenuPanel, BorderLayout.PAGE_END);
        
        window.addKeyListener(gameController);
        
        window.setSize(500, 600);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setLocationRelativeTo(null);
        
        window.setVisible(true);

        window.setResizable(false);

        window.pack();
                
        window.setFocusable(true);
    }

    /**
     * This method is responsible for clearing the game and menu panel's
     * and adding the "Charger Snake" and "Enter a name and click start. Use
     * arrow keys to move." messages to the GamePanel. The MenuPanel will add
     * the text field for the user to enter their name along with a start button.
     * Various layout managers were used to order position elements on screen.
     */
    private void drawStartFrame() {

        clearGamePanel();
        
        clearMenuPanel();
        
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        GamePanel.add(chargerSnakeMess);

        GamePanel.add(enterNameMess);
               
        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        MenuPanel.add(inputField);

        MenuPanel.add(startButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

    }
    /**
     * This method is responsible for clearing and adding to the game and menu panel's.
     * The GamePanel will add a new panel on top called GamePieces. GamePieces
     * itself will draw the snake and score object. The MenuPanel will add
     * the pause button, the score label, and the updated score. The pause button
     * will add an action listener which will be used by the controller to listen
     * for mouse clicks.Various layout managers were used to order 
     * position elements on screen.
     */
    private void drawGamePlayFrame() {

        clearGamePanel();
        
        clearMenuPanel();

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        GamePanel.add(new GamePieces(model));
        
        GamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        MenuPanel.add(pauseButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreLabelArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        pauseButton.addActionListener(controller);

    }

    /**
     * This method is responsible for clearing and adding to the game and menu panel's.
     * The GamePanel will add a pause message. The MenuPanel will add
     * the resume button, the score label, and the updated score. The resume button
     * will add an action listener which will be used by the controller to listen
     * for mouse clicks.Various layout managers were used to order 
     * position elements on screen.
     */
    private void drawPauseFrame() {

        clearGamePanel();
        
        clearMenuPanel();

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        GamePanel.add(pauseLabel);

        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        MenuPanel.add(resumeButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreLabelArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        resumeButton.addActionListener(controller);

    }
    
    /**
     * This method is responsible for clearing and adding to the game and menu panel's.
     * The GamePanel will add a new panel on top called LeaderBoard. LeaderBoard
     * itself will draw the LeaderBoard which will contain the name, score, and 
     * time of the top 10 player's. The MenuPanel will add the return to start 
     * button which when clicked will return to start frame.Various layout 
     * managers were used to order position elements on screen.
     */
    private void drawLeaderBoardFrame() {

        clearGamePanel();
        
        clearMenuPanel();

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        GamePanel.add(new LeaderBoard(model));

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        MenuPanel.add(returnToStartButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        returnToStartButton.addActionListener(controller);

    }

    /**
     * This method will clear off the top panel of the frame and 
     * get it ready to have new components or panels to be added.
     */
    private void clearGamePanel() {

        GamePanel.removeAll();
        
        GamePanel.revalidate();

        GamePanel.repaint();

    }
    
    /**
     * This method will clear off the bottom panel of the frame and 
     * get it ready to have new components or panels to be added.
     */
    private void clearMenuPanel() {

        MenuPanel.removeAll();

        MenuPanel.revalidate();

        MenuPanel.repaint();

    }

    /**
     * This will initialize the view, controller, and model for the program
     * @param args 
     */
    public static void main(String[] args) {
        new SnakeGUI(new SnakeController(), new SnakeModel());
    }
    
    /**
     * This method will return the start button to the controller for evaluation
     * @return 
     */
    public JButton getStart() {
        return startButton;
    }
    /**
     * This method will return the pause button to the controller for evaluation
     * @return 
     */
    public JButton getPause() {
        return pauseButton;
    }
    /**
     * This method will return the resume button to the controller for evaluation
     * @return 
     */
    public JButton getResume() {
        return resumeButton;
    }
    /**
     * This method will return the return to 
     * start button to the controller for evaluation
     * @return 
     */
    public JButton getReturnStart() {
        return returnToStartButton;
    }
    

/**
 * This method receives a message from the model telling it 
 * what method or methods to call in the view. 
 * @param m 
 */
    @Override
    public void update(Message m) {
        
        switch (m.getMessageContent()) {
            case "DrawStartFrame":
                    drawStartFrame();
                    break;   
            case "DrawLeaderBoardFrame":
                    drawLeaderBoardFrame();
                    break;
            case "DrawGamePlayFrame":
                    model.setName(inputField.getText());
                    drawGamePlayFrame();
                    break;        
            case "DrawPauseFrame":
                    drawPauseFrame();
                    break;        
            case "RePaintGameFrame":
                    window.repaint();
                    break;              
            case "ClearName":
                    inputField.setText("");
                    break;
            case "UpdateScore":
                    scoreLabelArea.setText(Integer.toString(model.getScore()));
                    break;       
                                
        }
       
    }
  
   }


