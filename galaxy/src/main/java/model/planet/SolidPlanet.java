package model.planet;

public class SolidPlanet extends Planet  implements  Atmosphere{
        private double minRotatioPeriod;
        private double maxRotatioPeriod;
        private double minSecondCosmicVelocity;
        private double maxSecondCosmicVelocity;
        private double minDensity;
        private double maxDensity;
        private double minRadius;
        private double maxRadius;
        private double minTemperature;
        private double maxTemperature;

        SolidPlanet(double w, double r, String n, double minSecondCosmicVelocity,double maxSecondCosmicVelocity,
                        double minDensity, double maxDensity, double minRadius, double maxRadius,
                        double minTemperature, double maxTemperature, double minRotatioPeriod, double maxRotatioPeriod) {
            super(w, r, n);
            this.maxRotatioPeriod=maxRotatioPeriod;
            this.minRotatioPeriod=minRotatioPeriod;
            this.minSecondCosmicVelocity = minSecondCosmicVelocity;
            this.minSecondCosmicVelocity = maxSecondCosmicVelocity;
            this.minDensity = minDensity;
            this.maxDensity = maxDensity;
            this.minRadius = minRadius;
            this.maxRadius = maxRadius;
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
        }


        public double getMinSecondCosmicVelocity() {
            return minSecondCosmicVelocity;
        }

        public void setMinSecondCosmicVelocity(double minSecondCosmicVelocity) {
            this.minSecondCosmicVelocity = minSecondCosmicVelocity;
        }

        public double getMinRotatioPeriod() {
            return minRotatioPeriod;
        }

        public void setMinRotatioPeriod(double minRotatioPeriod) {
            this.minRotatioPeriod = minRotatioPeriod;
        }

        public double getMaxRotatioPeriod() {
            return maxRotatioPeriod;
        }

        public void setMaxRotatioPeriod(double maxRotatioPeriod) {
            this.maxRotatioPeriod = maxRotatioPeriod;
        }

        public double getMaxSecondCosmicVelocity() {
            return maxSecondCosmicVelocity;
        }

        public void setMaxSecondCosmicVelocity(double maxSecondCosmicVelocity) {
            this.maxSecondCosmicVelocity = maxSecondCosmicVelocity;
        }
        public double getMinDensity() {
            return minDensity;
        }

        public void setMinDensity(double minDensity) {
            this.minDensity = minDensity;
        }

        public double getMaxDensity() {
            return maxDensity;
        }

        public void setMaxDensity(double maxDensity) {
            this.maxDensity = maxDensity;
        }

        public double getMinRadius() {
            return minRadius;
        }

        public void setMinRadius(double minRadius) {
            this.minRadius = minRadius;
        }

        public double getMaxRadius() {
            return maxRadius;
        }

        public void setMaxRadius(double maxRadius) {
            this.maxRadius = maxRadius;
        }

        public double getMinTemperature() {
            return minTemperature;
        }

        public void setMinTemperature(double minTemperature) {
            this.minTemperature = minTemperature;
        }

        public double getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(double maxTemperature) {
            this.maxTemperature = maxTemperature;
        }
}
