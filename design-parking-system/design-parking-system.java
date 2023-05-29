class ParkingSystem {

    int s;
    int m;
    int b;

    public ParkingSystem(int big, int medium, int small) {
        b = big;
        m = medium;
        s = small;
    }
    
    public boolean addCar(int carType) {
        if(carType ==3 ){
            if(s <= 0) return false;
            else {
                s -= 1;
                return true;
            }
        } else if (carType == 2){
            if(m <= 0) return false;
            else {
                m -= 1;
                return true;
            }
        } else {
            if(b <= 0) return false;
            else {
                b -= 1;
                return true;
            }
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */