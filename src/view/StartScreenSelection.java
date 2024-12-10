/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

/**
 *
 * @author Admin
 */

/// This class designed to manage the choices in the Super Mario Bros. game start screen.
/// Think of it as a 'console' for the player's initial options.


// Each selection will declare to a number for processing
public enum StartScreenSelection {
    START_GAME(0),
    VIEW_HELP(1),
    VIEW_ABOUT(2);

    private final int lineNumber;

    StartScreenSelection(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public StartScreenSelection getSelection(int number) {
        if (number == 0) {
            return START_GAME;
        } else if (number == 1) {
            return VIEW_HELP;
        } else if (number == 2) {
            return VIEW_ABOUT;
        } else {
            return null;
        }
    // Change number into suitable selection

    }


    // Give player permission to move up or down for selecting
    public StartScreenSelection select(boolean toUp) {
        int selection;

        if (lineNumber > -1 && lineNumber < 3) {
            selection = lineNumber - (toUp ? 1 : -1);
            if (selection == -1) {
                selection = 2;
            } else if (selection == 3) {
                selection = 0;
            }
            return getSelection(selection);
        }

        return null;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
