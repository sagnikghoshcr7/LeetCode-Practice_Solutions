class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int adTankFuel = Math.min((mainTank-1)/4, additionalTank);
        return (10*(mainTank + adTankFuel));
    }
}