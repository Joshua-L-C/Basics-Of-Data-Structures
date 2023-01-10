
public class MinimumDeleteionSize {
	
    int toDelete = 0;

    public int minDeletionSize(String[] strs) {

        recurColumns(strs,0);

        return toDelete;
    } //strs[i].charAt(j) - 'a'


    public void recurColumns(String[] strs, int index){

        if(index >= strs[0].length()){
            return;
        }

        //System.out.println(strs[0].charAt(index));

        recurRows(strs,index,0, strs[0].charAt(index) - 'a');
        recurColumns(strs,index + 1);

        return;
    }

    public void recurRows(String[] strs,int columIndex , int rowIndex, int currentGreatest){

        if(rowIndex >= strs.length){
           return;
        }

        int hold = (int)strs[rowIndex].charAt(columIndex)  - 'a';

        if(currentGreatest > hold){
           toDelete++;
            return;
        }

        if(currentGreatest < hold){
           currentGreatest = hold;
        }

        recurRows(strs,columIndex,rowIndex + 1, currentGreatest);

        return;
    }

    public int minDeletionSize1(String[] strs) {
        
        int delColNum = 0;
        int largestVal = 0;
        int currentVal = 0;

        for(int colIndx = 0; colIndx < strs[0].length(); colIndx++){

            largestVal = (int)(strs[0].charAt(colIndx));

            for(int rowIndx = 0; rowIndx <strs.length;rowIndx++){

                currentVal = (int)(strs[rowIndx].charAt(colIndx));

                if(largestVal <= currentVal){
                    
                    largestVal = currentVal;
                }else if(largestVal > currentVal){
            
                    delColNum++;
                    break;
                }

            }

            largestVal = 0;
            currentVal = 0;

        }

        return delColNum;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
