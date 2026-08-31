class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainingHours=0;
        int totalEnergy=0;
        for(int e:energy){
            totalEnergy+=e;
        }
        if(initialEnergy<=totalEnergy){
            trainingHours+=totalEnergy-initialEnergy+1;
        }
        int currentExperience=initialExperience;
        for(int i=0;i<experience.length;i++){
            if(currentExperience<=experience[i]){
                int needed=experience[i]-currentExperience+1;
                trainingHours+=needed;
                currentExperience+=needed;
            }
            currentExperience+=experience[i];
        }
        return trainingHours;
        
    }
}