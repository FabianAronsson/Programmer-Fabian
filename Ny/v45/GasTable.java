public enum GasTable{

    AIR(1.29, 1.01),
    O2(1.43, 0.92),
    OXYGEN(1.43, 0.92),
    He(0.178, 5.2), //Helium
    C3H8(2.02,1.53) //Propan
    ;

    double density;
    double heatCapacity;

    GasTable(double d, double hc) {
        density = d;
        heatCapacity = hc * 1E3; // 1E3 = 1*10^3
    }

}