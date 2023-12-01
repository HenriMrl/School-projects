package oy.tol.tra;
// kaikki kurssin algoritmit

import java.util.function.Predicate;

public class Algorithms {

     public static <T extends Comparable<T>> void sort(T [] array) {
      boolean vaihto = true;
      while(vaihto){
      vaihto = false;
      for(int i = array.length-1; i > 0; i--){
         if (array[i].compareTo(array[i-1]) < 0){
            vaihto = true;
            swap(array, i, i-1);
         }

      }
   }
}

// reverse algoritmi
    public static <T> void reverse(T [] array) {
      int i = 0;
      while (i < array.length/2) {
         T temp = array[i];
         array[i] = array[array.length-i-1];
         array[array.length-i-1] = temp;
         i++;
     }
  }

  // swap algoritmi
  public static <T> void swap(T [] array, int first, int second){
     T temp = array[first];
     array[first] = array[second];
     array[second] = temp;
   }

   // mode algoritmi
   public static class ModeSearchResult<T> {
      public T theMode;
      public int count = 0;
  }
   
  // mode algoritmi
   public static <T extends Comparable<T>> ModeSearchResult<T> findMode(T [] array) {
        ModeSearchResult<T> result = new ModeSearchResult<>();
        result.theMode = null;
        result.count = -1;     
        if(array == null || array.length < 2){
         return result;
        }
        sort(array);

        result.theMode = array[0];
        result.count = 1;

        int topFrequency = 1;
        int tempFrequency = 1;
        int index = 1;
        
        while(index < array.length){
         if(array[index].compareTo(array[index-1]) == 0){
            tempFrequency++;
        } 
         else { 
           if (tempFrequency > topFrequency){
            result.count = tempFrequency;
            result.theMode = array[index-1];
            topFrequency = tempFrequency;
           }
           tempFrequency = 1;
         }
         index++;
      }
      if (tempFrequency > topFrequency){
         result.count = tempFrequency;
         result.theMode = array[index-1];
         topFrequency = tempFrequency;
        }
      return result;
    }

   // osittelu algoritmi
   public static <T> int partitionByRule(T [] array, int count, Predicate<T> rule){
      if(null == array){
         return -1;
      }
      int index = 0;
      for( ; index < count; index++){
         if(rule.test(array[index])){
             break; 
         }
      }
      if(index >= count){
         return count;
      }
      int nextindex = index + 1; 
      while(nextindex < count){
         if(!rule.test(array[nextindex])){
            swap(array, index, nextindex);
            index++;
         }
         nextindex++;
      }
      return index;
    }
    
    // puolitushaku
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
      if(fromIndex == toIndex){
         if(fromArray[fromIndex].compareTo(aValue) == 0){
            return fromIndex;
         } else {
            return -1;
         }
      } else {
         int middle = fromIndex + (toIndex - fromIndex) / 2;
         if (aValue.compareTo(fromArray[middle]) <= 0){
            return binarySearch(aValue, fromArray, fromIndex, middle);
         } else {
            return binarySearch(aValue, fromArray, middle + 1, toIndex);
         }
      }
      
   }

// Fast sort 
public static <E extends Comparable<E>> void fastSort(E [] array){
   quickSort(array, 0, array.length - 1);
}


// quick sort 
private static <E extends Comparable<E>> void quickSort(E [] array, int low, int high){
   if(low < high){
      int partitionIndex = partition(array, low, high);
      quickSort(array, low, partitionIndex - 1);
      quickSort(array, partitionIndex + 1, high);
   }

}
// partition
private static <E extends Comparable<E>> int partition(E [] array, int low, int high){
   E pivotValue = array[high];
   int i = low - 1;
   for (int j = low; j < high; j++){
      if(array[j].compareTo(pivotValue) < 0){
         i++;
         swap(array, i, j);
      }
   }
   swap(array, i + 1, high);
   return i + 1;
}




}





