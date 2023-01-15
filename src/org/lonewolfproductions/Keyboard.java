package org.lonewolfproductions;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Keyboard {

    KeyboardHandler keyboardHandler;

    public Keyboard(KeyboardHandler keyboardHandler){
        this.keyboardHandler = keyboardHandler;
        initKeyboard();
    }

    private void initKeyboard() {
        org.academiadecodigo.simplegraphics.keyboard.Keyboard keyboard = new org.academiadecodigo.simplegraphics.keyboard.Keyboard(keyboardHandler);

        KeyboardEvent W_Pressed = new KeyboardEvent();
        W_Pressed.setKey(KeyboardEvent.KEY_W);
        W_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent A_Pressed = new KeyboardEvent();
        A_Pressed.setKey(KeyboardEvent.KEY_A);
        A_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent S_Pressed = new KeyboardEvent();
        S_Pressed.setKey(KeyboardEvent.KEY_S);
        S_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent D_Pressed = new KeyboardEvent();
        D_Pressed.setKey(KeyboardEvent.KEY_D);
        D_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent SPACE_Pressed = new KeyboardEvent();
        SPACE_Pressed.setKey(KeyboardEvent.KEY_SPACE);
        SPACE_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent C_Pressed = new KeyboardEvent();
        C_Pressed.setKey(KeyboardEvent.KEY_C);
        C_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent P_Pressed = new KeyboardEvent();
        P_Pressed.setKey(KeyboardEvent.KEY_P);
        P_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent L_Pressed = new KeyboardEvent();
        L_Pressed.setKey(KeyboardEvent.KEY_L);
        L_Pressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(W_Pressed);
        keyboard.addEventListener(A_Pressed);
        keyboard.addEventListener(S_Pressed);
        keyboard.addEventListener(D_Pressed);
        keyboard.addEventListener(SPACE_Pressed);
        keyboard.addEventListener(C_Pressed);
        keyboard.addEventListener(P_Pressed);
        keyboard.addEventListener(L_Pressed);

    }

}
