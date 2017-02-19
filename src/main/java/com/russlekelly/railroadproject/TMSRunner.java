package com.russlekelly.railroadproject;

import com.russlekelly.railroadproject.view.ConsoleHelper;

import java.text.ParseException;

/**
 * Created by RuslanKuleshov on 12.02.17.
 */
public class TMSRunner {
    public static void main(String[] args) throws ParseException {
        ConsoleHelper consoleHelper = new ConsoleHelper();


        //consoleHelper.showTicketMenu();

        consoleHelper.getStationView().showStationMenu();

    }
}
