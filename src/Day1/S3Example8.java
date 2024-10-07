        if (examMark < 0 || examMark > 100) {
            System.out.println("Invalid mark entered - needs to be in the range 0..100");
        } else if (examMark >= 70) {
            System.out.println("An exceptional result!");
            System.out.println("We expect a first-class project from you.");
        } else if (examMark >= 50) {
            System.out.println("A satisfactory result!");
            System.out.println("You may proceed with your project.");
        } else {
            System.out.println("Sorry, you have failed.");
        }
