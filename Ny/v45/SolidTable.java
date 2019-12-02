public enum SolidTable {

    ICE(0.92, 2.2, 0, 334),
    IRON(7.87, 0.45, 1538, 276),
    SILICON(2.3, 0.71, 1410, 165),
    NAPHTHALENE(1.15, 1.3, 80, 150),
    SULFUR(2.1, 0.74, 120, 38),
    GOLD(19.3, 0.129, 1064.18, 63),
    SAND(1.602, 0.84, 1610, 156),
    SILVER(10.49, 0.24, 961.78, 104.4),
    COPPER(8.96, 0.385, 1084.62, 205.4),
    PALLADIUM(12.023, 0.24, 1554.9, 165),
    LEAD(11.34, 0.16, 324.46, 23),
    TELLURIUM(6.24, 0.2, 449.51, 137.0),
    ;

    double density;
    double heatCapacity;
    double meltPoint;
    double meltEntalpy;

    SolidTable(double d, double hc, double sp, double se) {
        density = d * 1E3;
        heatCapacity = hc * 1E3;
        meltPoint = sp;
        meltEntalpy = se * 1E3;
    }


}