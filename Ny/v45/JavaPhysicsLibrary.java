public class JavaPhysicsLibrary {                       //alla enheter är givna enligt SI-systemet om inget annat anges
    static double G = 6.67 * Math.pow(10, -11);
    static double R = 8.314472;
    static double p_0 = 1013.25;
    static double c = 299792458;
    static double g_swe = 9.82;

    public static void main(String[] args) {
        //Hur mycket väger 60 dm^3 järn?
        System.out.println(volumeToMass(SolidTable.IRON, 0.06));

        //Hur långt hinner Tomas om han löper med medelhastigheten 2.7 m/s i 50 minuter?
        System.out.println(svtDistance(2.7, 3000));

        //Hur mycket energi krävs för att värma upp 4 liter vatten från rumstemperatur (22 grader) till kokpunkten?
        System.out.println(heat(FluidTable.WATER, 4, 22));

        //Hur stort är det totala trycket 75 meter under havsytan?
        System.out.println(pressureUnderWater(75));

        //Tomas som är 180cm lång kastar upp en boll med massan 250 gram i luften så
        // den får starthastigheten 60 km/h. Hur högt kommer bollen?
        System.out.println(velocityToHeight(17) + 1.8); //1.8 är höjden som föremålet kastades ifrån.

        //En bil med massan 735kg accelererar med konstant acceleration från 0-100 på 4.8 sekunder.
        // Hur stor effekt har bilens motor uppnått?
        System.out.println(power(work(force(acceleration(100 / 3.6, 4.8), 735), distance(4.8, 28)), 4.8));

        //En studsboll släpps från 12 meters höjd och varje gång den nuddar marken tappar den 1% av sin energi.
        // Hur många gånger kommer bollen studsa i marken innan den inte studsar hörge än 0.5 meter?
        System.out.println(amountOfBounces(12));

        //Alex kör en bil med den konstanta accelerationen 10 m/s^2, vad blir hans hastighet efter 4,3s?
        System.out.println(velocity(10, 4.3));

        //En vikt på 5 kg hänger helt stilla i taket med hjälp av en fjäder som har fjäderkonstanten 85 N/m. Hur långt är fjädern utdragen?
        System.out.println(length(5, 85));

        //Räkna ut vinkelhastigheten för ett däck då däcket är 1m i diameter och bilen som däcket sitter på kör i 18 m/s.
        System.out.println(angularVelocity(18, 0.5));
    }

    /**
     * Denna metod konverterar fahrenheit till celsius genom att använda sig av en formel.
     *
     * @param fahrenheit Indata för fahrenheit.
     * @return Retunerar temperaturen i celsius.
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    /**
     * Denna metod omvandlar kelvin till celsius genom att anvädna sig av en känd formel.
     *
     * @param kelvin Tar in ett värde för kelvin.
     * @return Retunerar indatan i celsius.
     */
    public static double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    /**
     * Denna metod räknar ut vätsketrycket i en viss vätska under ett visst djup med hjälp av en känd formel. I detta fall är det aceton.
     *
     * @param fluid Här är indata för densiteten av en vätska - aceton i detta fall.
     * @param deep  Indata för djupet. Nuvarande indata är 10 meter under vatten.
     * @return Retunerar vätsketrycket under vatten i viss vätska.
     */
    public static double fluidPressure(FluidTable fluid, double deep) {
        return (fluid.density * g_swe * deep);
    }

    /**
     * Räknar ut vätsketrycket i vatten vid ett viss djup med samma formel som tidigare, skillnaden är att vi nu har vatten istället.
     *
     * @param deep Djupet där man mäter trycket.
     * @return Returnerar vätsketrycket.
     */
    public static double pressureUnderWater(double deep) {
        return (FluidTable.WATER.density * g_swe * deep);

    }

    /**
     * Denna metod räknar ut den kinetiska energin med hjälp av en känd formel.
     *
     * @param mass     Massan på objektet.
     * @param velocity Hastigheten på objektet.
     * @return Returnerar den kinetiska energin.
     */
    public static double kineticEnergy(double mass, double velocity) {
        return ((mass * Math.pow(velocity, 2)) / 2);

    }

    /**
     * Denna metod räknar ut den potentiella energin ett objekt kan ha genom att använda en känd formel.
     *
     * @param mass   Indata för massan på objektet.
     * @param height Indata för höjden som objeket befinner sig på relativt till nollpunkten. Där nollpunkten är den punkt man mäter höjden ifrån.
     * @return Retunerar den potentiella energin objeket har.
     */
    public static double potentialEnergy(double mass, double height) {
        return (mass * g_swe * height);
    }

    /**
     * Räknar ut den maximala hastigheten som ett objekt har om den släpps från en viss höjd. Formeln är en härledning från lägesenergi och rörelseenergi.
     * Där man kan sätta m * g * h = 1/2 * m * v^2. Massorna tar ut varandra och om vi multiplicerar med 2 samt tar roten ur får vi att v = sqrt(2 * g * h).
     *
     * @param height Höjden objektet släpps ifrån.
     * @return Retunerar den sluthastigheten.
     */
    public static double fallSpeed(double height) {
        return (Math.sqrt(2 * g_swe * height));
    }

    /**
     * Denna metod räknar ut skillnaden mellan två värden.
     *
     * @param first Indata för första värdet.
     * @param last  Indata för andra värdet.
     * @return Retunerar differensen mellan värdena.
     */
    public static double delta(double first, double last) {
        return (last - first);
    }

    /**
     * Metoden omvandlar en vätskas volym till vad den väger i massa.
     *
     * @param fluid  Indata för vätska.
     * @param volume Indata för volym.
     * @return Retunerar vad vätskan väger i massa.
     */
    public static double volumeToMass(FluidTable fluid, double volume) {
        return (FluidTable.WATER.density * volume);
    }

    /**
     * Denna metod räknar ut vad en gas volym väger i massa med hjälp av densitetsformeln. p = m / V => m = p * V.
     *
     * @param gas    Indata för en gas.
     * @param volume Indata för volymen på gasen.
     * @return Retunerar vad gasen väger i massa.
     */
    public static double volumeToMass(GasTable gas, double volume) {
        return (gas.density * volume);
    }

    /**
     * Denna metod räknar ut vad en massa i volym blir i massa med densitetsformeln.
     *
     * @param solid  Indata för det solida ämnet
     * @param volume Indata för volymen på gasen.
     * @return Retunerar vad massan blir.
     */
    public static double volumeToMass(SolidTable solid, double volume) {
        return (solid.density * volume);
    }

    /**
     * Metoden räknar ut vad medelhastigheten blir genom att använda sig av v = s / t.
     *
     * @param distance Indata för sträckan objektet har färdats.
     * @param time     Tiden det tog för objektet att färdats.
     * @return Retunerar medelhastigheten.
     */
    public static double svtVelocity(double distance, double time) {
        return (distance / time);
    }

    /**
     * Denna metod räknar ut vad sträckan blir om man vet vad hastigheten samt tiden är.
     *
     * @param velocity Indata för hastigheten.
     * @param time     Indata för tiden.
     * @return Retunerar sträckan.
     */
    public static double svtDistance(double velocity, double time) {
        return (velocity * time);
    }

    /**
     * Denna metod räknar ut hur lång tid det tar för ett objekt om man vet sträckan samt hastigheten.
     *
     * @param distance Indata för sträcka.
     * @param velocity Indata för hastighet.
     * @return Retunerar tiden.
     */
    public static double svtTime(double distance, double velocity) {
        return (distance / velocity);
    }

    /**
     * Denna metod räknar ut vad arbetet blir om man vet kraften samt sträckan.
     *
     * @param force    Indata för kraft.
     * @param distance Indata för sträcka.
     * @return Retunerar arbetet.
     */
    public static double work(double force, double distance) {
        return (force * distance);
    }

    /**
     * Denna metod räknar ut vad för effekt ett objekt kommer att ha om man vet arbetet samt tiden.
     *
     * @param work Indata för arbete.
     * @param time Indata för tid.
     * @return Retunerar effekten.
     */
    public static double power(double work, double time) {
        return (work / time);
    }

    /**
     * Denna metod räknar ut hur mycket energi som krävs för att värme upp ett visst material till en viss temperatur.
     *
     * @param solid  Indata för materialet.
     * @param mass   Indata för massan.
     * @param deltaT Indata för skillnaden i temperatur.
     * @return Retunerar hur mycket energi som krävs.
     */
    public static double heat(SolidTable solid, double mass, double deltaT) {
        return (solid.heatCapacity * mass * deltaT);
    }

    /**
     * Denna metod räknar ut hur mycket energi det krävs för att värma upp en vätska till en viss temperatur.
     *
     * @param fluid  Indata för vätska.
     * @param mass   Indata för massa.
     * @param deltaT Indata för skilnaden i temperatur.
     * @return Retunerar hur mycket energi som krävs.
     */
    public static double heat(FluidTable fluid, double mass, double deltaT) {
        return (fluid.heatCapacity * mass * deltaT);
    }

    /**
     * Denna metod räknar ut hur mycket energi det krävs för att värma upp en gas till en viss värme med hjälp av en känd formel.
     *
     * @param gas    Indata för en gas.
     * @param mass   Indata för en massa.
     * @param deltaT Indata för skillnaden i temperatur.
     * @return Retunerar energin som krävs .
     */
    public static double heat(GasTable gas, double mass, double deltaT) {
        return (gas.heatCapacity * mass * deltaT);
    }

    /**
     * Denna metod räknar ut hur högt ett objekt kommer om man vet en viss hastighet.
     *
     * @param velocity Indata för hastigheten.
     * @return Retunerar höjden.
     */
    public static double velocityToHeight(double velocity) {
        return (Math.pow(Math.sin(1.570796), 2) * Math.pow(velocity, 2)) / (2 * g_swe);
    }

    /**
     * Denna metod räknar ut vad fjäderkonstanten är om man vet kraften och skillnaden i förlängning av fjädern.
     *
     * @param force                       Indata för kraften.
     * @param differenceOfSpringExtension Indata för skillnaden i förlängning av fjädern.
     * @return Retunerar fjäderkonstanten.
     */
    public static double springConstant(double force, double differenceOfSpringExtension) {
        return (force * differenceOfSpringExtension);
    }

    /**
     * Denna metod räknar ut vad tyngdaccelerationen är på en planet om man vet vad massan samt radien är.
     *
     * @param mass   Indata för massa på planet.
     * @param radius Indata för radie på samma planet.
     * @return Retunerar tyngdaccelerationen.
     */
    public static double accelerationDueToGravity(double mass, double radius) {
        return (G * (mass / Math.pow(radius, 2)));
    }

    /**
     * Denna metod räknar ut vad trycket blir om man vet vad kraften är då den är vinkelrät riktad mot en känd area.
     *
     * @param force Indata för kraft.
     * @param area  Indata för arean.
     * @return Retunerar trycket.
     */
    public static double pressure(double force, double area) {
        return (force / area);
    }

    /**
     * Denna metod räknar ut vad spänningen blir om man vet resistansen och strömmen.
     *
     * @param resistance Indata för resistans i Ohm.
     * @param current    Indata för ström i Ampere.
     * @return Retunerar spänningen i Volt.
     */
    public static double voltage(double resistance, double current) {
        return (resistance * current);
    }

    /**
     * Denna metod räknar ut vad vinkelhastigheten blir om man vet vad frekvensen är.
     *
     * @param velocity Indata för hastighet i m/s.
     * @param radius   Indata för radien på objektet i meter.
     * @return Retunerar vinkelhastigheten i Hz.
     */
    public static double angularVelocity(double velocity, double radius) {
        return (velocity / radius);
    }

    /**
     * Metoden räknar ut vad den absorberade dosen blir om man vet hur mycket energi strålningen har samt om man vet massan på en kropp.
     *
     * @param mass            Indata för massan på en massa.
     * @param radiationEnergy Indata för strålningens energi.
     * @return Retunerar den absorberade dosen strålning.
     */
    public static double absorbedDose(double mass, double radiationEnergy) {
        return (radiationEnergy / mass);
    }

    /**
     * Denna metod räknar ut vad accelerationen blir om man vet hastigheten och tiden.
     *
     * @param velocity Indata för hastighet.
     * @param time     Indata för tid.
     * @return Retunerar accelerationen.
     */
    public static double acceleration(double velocity, double time) {
        return (velocity / time);
    }

    /**
     * Metoden räknar ut vad sträckan är om man vet tiden samt accelerationen.
     *
     * @param time         Indata för tid.
     * @param acceleration Indata för acceleration.
     * @return Retunerar sträckan.
     */
    public static double distance(double time, double acceleration) {
        return ((acceleration * Math.pow(time, 2)) / 2);
    }

    /**
     * Denna metod räknar ut vad kraften blir om man vet vad accelerationen och massan är.
     *
     * @param acceleration Indata för acceleration.
     * @param mass         Indata för massa.
     * @return Retunerar kraften.
     */
    public static double force(double acceleration, double mass) {
        return (mass * acceleration);
    }

    /**
     * Denna metod räknar ut hur många gånger en boll kommer studsa om den förlorar 1% av sin energi efter varje studs.
     *
     * @param height Indata för höjden.
     * @return Retunerar antal gånger bollen har studsat.
     */
    public static double amountOfBounces(double height) {
        double finalPotentialEnergy = height * g_swe;
        int bounceCounter = 0;
        double i = 12;
        while (i >= 0.5) {
            finalPotentialEnergy *= 0.99;
            i = finalPotentialEnergy / g_swe;
            bounceCounter++;
        }
        return bounceCounter;
    }

    /**
     * Denna metod räknar ut vad ett föremåls hastighet efter en viss tid, om man vet vad accelerationen är, såvida den är konstant.
     *
     * @param constantAcceleration Indata för acceleration.
     * @param time                 Indata för tid.
     * @return Retunerar hastigheten.
     */
    public static double velocity(double constantAcceleration, double time) {
        return (constantAcceleration * time);
    }

    /**
     * Denna metod räknar ut hur långt en fjäder kommer sträckas ut ifall en vikt hänger på den, om man vet vad massan och fjäderkonstanten är.
     *
     * @param mass           Indata för massan på vikten.
     * @param springConstant Indata fär fjäderkonstanten.
     * @return Retunerar hur långt fjäder har sträckts ut när vikten hänger i fjädern.
     */
    public static double length(double mass, double springConstant) {
        return ((mass * g_swe) / springConstant);
    }
}
