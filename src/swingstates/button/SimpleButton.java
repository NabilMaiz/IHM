package swingstates.button;

import fr.lri.swingstates.canvas.*;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.canvas.transitions.EnterOnShape;
import fr.lri.swingstates.canvas.transitions.LeaveOnShape;
import fr.lri.swingstates.canvas.transitions.PressOnShape;
import fr.lri.swingstates.canvas.transitions.ReleaseOnShape;
import fr.lri.swingstates.debug.StateMachineVisualization;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Press;
import fr.lri.swingstates.sm.transitions.Release;

import javax.swing.*;
import java.awt.*;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * @modified Maiz Nabil & Ouartsi Wassim
 */

public class SimpleButton {

    private CText label ;
    private CRectangle buttonBody;

    SimpleButton(Canvas canvas, String text) {

        CExtensionalTag selected = new CExtensionalTag(canvas){};

        JFrame fsmVisualisation = new JFrame();

        fsmVisualisation.show();

        label = canvas.newText(0, 0, text, new Font("verdana", Font.PLAIN, 14)) ;
        buttonBody = canvas.newRectangle(0, 0, 50, 35);

        label.above(buttonBody);
        buttonBody.setParent(label);
        buttonBody.addTag(selected);

        CStateMachine sm = new CStateMachine() {

            public State idle = new State() {

                Transition hoverOnShape = new EnterOnShape(">> hover") {
                    public void action()  {
                        buttonBody.setStroke(new BasicStroke(2));
                    }
                };
            };

            public State deactivated = new State() {

                Transition releaseOnBackground = new Release(BUTTON1, ">> idle") {
                    public void action() {
                        buttonBody.setFillPaint(Color.lightGray);
                    }
                };

                Transition releaseOnShape = new ReleaseOnShape(BUTTON1, ">> click") {
                    public void action()  {
                        buttonBody.setFillPaint(Color.lightGray);
                    }
                };

                Transition hoverOnShape = new EnterOnShape() {
                    public void action()  {
                        buttonBody.setStroke(new BasicStroke(2));
                    }
                };

                Transition LEAVEOnShape = new LeaveOnShape() {
                    public void action()  {
                        buttonBody.setStroke(new BasicStroke(1));
                    }
                };

            };

            public State click = new State() {

                Transition leave = new Release(BUTTON1, ">> deactivated") {
                    public void action() {
                        buttonBody.setFillPaint(Color.lightGray);
                        doClick();
                    }
                };

                Transition hoverOnShape = new EnterOnShape(">> hover") {
                    public void action()  {
                        buttonBody.setStroke(new BasicStroke(2));
                    }
                };

                Transition leaveShape = new LeaveOnShape(" >> deactivated") {
                    public void action() {
                        buttonBody.setStroke(new BasicStroke(1));
                    }
                };


            };

            public State hover = new State() {

                Transition pressOnShape = new PressOnShape(BUTTON1, ">> click") {
                    public void action() {
                        buttonBody.setFillPaint(Color.GRAY);
                    }
                };

                Transition leaveShape = new LeaveOnShape(" >> idle") {
                    public void action() {
                        buttonBody.setStroke(new BasicStroke(1));
                    }
                };

                Transition leave = new Release(BUTTON1, ">> click") {
                    public void action() {
                        buttonBody.setFillPaint(Color.lightGray);
                        doClick();
                    }
                };
            };
        };
        sm.attachTo(canvas);
        sm.armTimer(300, true);
        StateMachineVisualization smv = new StateMachineVisualization(sm);
        fsmVisualisation.add(smv);
    }

    public void doClick(){
        System.out.println("mothaaaaaa");
    }

    public void action() {
        System.out.println("ACTION!") ;
    }

    public CShape getShape() {
        return label ;
    }

    static public void main(String[] args) {
        JFrame frame = new JFrame() ;
        Canvas canvas = new Canvas(400,400) ;
        frame.getContentPane().add(canvas) ;
        frame.pack() ;
        frame.setVisible(true) ;

        SimpleButton simple = new SimpleButton(canvas, "simple") ;
        simple.getShape().translateBy(150,100) ;
    }

}