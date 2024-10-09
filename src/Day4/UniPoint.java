class UniPoint {
    int x; // instance variable

    int getX() {
        return x;    // x is from line 2
    }

    void setX(int x) {
        this.x = x;  // this.x is from line 2
    }                //      x is from line 8 (!)

    UniPoint duplicate() { // no static!
        UniPoint copy = new UniPoint();
        copy.setX(x); // method call: varName.methodName(arg)
        return copy;
    }
}
