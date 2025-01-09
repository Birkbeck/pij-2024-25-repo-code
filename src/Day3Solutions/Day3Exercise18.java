import java.util.Scanner;

public class Day3Exercise18 {
    public static void main(String[] args) {
        // some variables to hold the relevant instructions ("final" is
        // optional, but helpful to indicate and check that they will
        // not be changed
        final String MAIL_FROM = "MAIL FROM: ";
        final String RCPT_TO = "RCPT TO: ";
        final String DATA = "DATA";
        final char ADDRESS_INFIX = '@'; // must be present in every email address
        final String END_MESSAGE = ".";
        final String QUIT = "QUIT";
        final String PROMPT = ">>> ";
        final String WELCOME_MSG = "Welcome to My Mail Server!";
        final String OK_MSG = "OK";
        final String INVALID_COMMAND_MSG = "Invalid command.";
        final String INVALID_ADDRESS_MSG = "Invalid address";
        final String SENDING_MSG = "Sending email...";
        final String FROM_MSG = "from: ";
        final String TO_MSG = "to: ";
        final String DONE_MSG = "...done!";
        final String BYE_MSG = "Bye!";

        Scanner scan = new Scanner(System.in);
        System.out.println(WELCOME_MSG);

        // set to true when the QUIT command is read on the prompt
        boolean needToQuit = false;

        while (! needToQuit) {
            // first we must read the MAIL FROM command for
            // the sender's address (or QUIT)
            String senderAddress = "";
            boolean senderValidated = false;
            while (!needToQuit && !senderValidated) {
                System.out.print(PROMPT);
                String senderCommand = scan.nextLine();
                if (QUIT.equals(senderCommand)) {
                    needToQuit = true;
                } else if (senderCommand.startsWith(MAIL_FROM)) {
                    int addressStart = MAIL_FROM.length();
                    // senderCommand.substring(addressStart) is a shortcut for
                    // senderCommand.substring(addressStart, senderCommand.length())
                    senderAddress = senderCommand.substring(addressStart);

                    // to validate the address, let's check how many
                    // ADDRESS_INFIX occurrences we can find in the address
                    int numberOfAtSymbolsInAddress = 0;
                    int i = 0;
                    while (i < senderAddress.length()) {
                        if (ADDRESS_INFIX == senderAddress.charAt(i)) {
                            numberOfAtSymbolsInAddress = numberOfAtSymbolsInAddress + 1;
                        }
                        i++;
                    }

                    if (numberOfAtSymbolsInAddress == 1) {
                        senderValidated = true;
                        System.out.println(OK_MSG);
                    } else {
                        System.out.println(INVALID_ADDRESS_MSG);
                        System.out.print(PROMPT);
                    }
                } else {
                    System.out.println(INVALID_COMMAND_MSG);
                    System.out.print(PROMPT);
                }
            }

            // now we must read the command for the recipient's address (or QUIT)
            String recipientAddress = "";
            boolean recipientValidated = false;
            while (!needToQuit && !recipientValidated) {
                System.out.print(PROMPT);
                String recipientCommand = scan.nextLine();
                if (QUIT.equals(recipientCommand)) {
                    needToQuit = true;
                } else if (recipientCommand.startsWith(RCPT_TO)) {
                    int addressStart = RCPT_TO.length();
                    recipientAddress = recipientCommand.substring(addressStart);

                    // to validate the address, let's check how many
                    // ADDRESS_INFIX occurrences we can find in the address
                    int numberOfAtSymbolsInAddress = 0;
                    int i = 0;
                    while (i < recipientAddress.length()) {
                        if (ADDRESS_INFIX == recipientAddress.charAt(i)) {
                            numberOfAtSymbolsInAddress = numberOfAtSymbolsInAddress + 1;
                        }
                        i++;
                    }

                    if (numberOfAtSymbolsInAddress == 1) {
                        recipientValidated = true;
                        System.out.println(OK_MSG);
                    } else {
                        System.out.println(INVALID_ADDRESS_MSG);
                        System.out.print(PROMPT);
                    }
                } else {
                    System.out.println(INVALID_COMMAND_MSG);
                    System.out.print(PROMPT);
                }
            }

            // next, we expect the DATA command (or QUIT)
            boolean dataValidated = false;
            while (!dataValidated && !needToQuit) {
                System.out.print(PROMPT);
                String dataCommand = scan.nextLine();
                if (QUIT.equals(dataCommand)) {
                    needToQuit = true;
                } else if (DATA.equals(dataCommand)) {
                    dataValidated = true;
                } else {
                    System.out.println(INVALID_COMMAND_MSG);
                    System.out.print(PROMPT);
                }
            }

            // now we expect the actual data for the email body
            // (no QUIT at this point, there's no prompt, and
            // the email body may contain that word)
            String emailBody = "";
            boolean emailBodyFinished = false;
            while (!needToQuit && !emailBodyFinished) {
                String inputLine = scan.nextLine();
                if (END_MESSAGE.equals(inputLine)) {
                    emailBodyFinished = true;
                } else {
                    // "\n" is needed because scan.nextLine() does not return the
                    // newline symbol at the end
                    emailBody = emailBody + inputLine + "\n";
                }
            }

            if (needToQuit) {
                System.out.println(BYE_MSG);
            } else {
                System.out.println(SENDING_MSG);
                System.out.println(FROM_MSG + senderAddress);
                System.out.println(TO_MSG + recipientAddress);
                System.out.print(emailBody);
                System.out.println(DONE_MSG);
            }
        }
    }
}
