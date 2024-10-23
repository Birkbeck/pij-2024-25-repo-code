package pij.day8.phonePolymorphism;

public class PhoneLauncher {

    public void launch() {
        OldPhone oldPhone = new OldPhone("ACME");
        oldPhone.call("555123456");

        MobilePhone mobilePhone = new MobilePhone("ACME mobile division");
        mobilePhone.ringAlarm("Wake up!");
        mobilePhone.playGame("Tetris!");
        mobilePhone.call("1234");
        mobilePhone.call("2678");
        mobilePhone.call("3678");
        mobilePhone.call("4678");
        mobilePhone.call("5678");
        mobilePhone.call("6678");
        mobilePhone.call("7678");
        mobilePhone.call("8678");
        mobilePhone.call("9678");
        mobilePhone.call("10678");
        mobilePhone.call("11678");
        mobilePhone.call("12678");
        mobilePhone.call("13678");
        mobilePhone.printLastNumbers();
        testPhone(mobilePhone);

        SmartPhone smartPhone = new SmartPhone("Smart ACME");
        //MobilePhone smartPhone = new SmartPhone("Smart ACME");
        smartPhone.ringAlarm("Wake up!");
        smartPhone.playGame("Tetris!");
        smartPhone.call("1234");
        smartPhone.call("2678");
        smartPhone.call("003678");
        smartPhone.call("4678");
        smartPhone.call("5678");
        smartPhone.call("6678");
        smartPhone.call("7678");
        smartPhone.call("8678");
        smartPhone.call("9678");
        smartPhone.call("10678");
        smartPhone.call("11678");
        smartPhone.call("12678");
        smartPhone.call("13678");
        smartPhone.printLastNumbers();
        smartPhone.browseWeb("localhost");
        smartPhone.findPosition();
        System.out.println(smartPhone.getBrand());

        testPhone(smartPhone);
    }

    private void testPhone(Phone phone) {
        ((SmartPhone)phone).browseWeb("");
    }

    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
}
