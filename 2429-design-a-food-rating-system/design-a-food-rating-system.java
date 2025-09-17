class FoodRatings {

    public class Food{
        String name;
        int rate;
        public Food(String name, int rate){
            this.name = name;
            this.rate = rate;
        }

        @Override
        public String toString(){
            return "(" + name + ", " + rate + ")";
        }
    }

    public HashMap<String, PriorityQueue<Food>> map= new HashMap<>();
    public HashMap<String, String> cuisineDict = new HashMap<>();
    public HashMap<String, Food> foodDict = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for(int i =0; i<foods.length;i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rate = ratings[i];
            PriorityQueue<Food> temp = map.getOrDefault(cuisine, new PriorityQueue<>((o1,o2) -> {
                if(o1.rate == o2.rate){
                    return o1.name.compareTo(o2.name);
                }
                return o2.rate-o1.rate;}
                ));
            Food f = new Food(food,rate);
            temp.add(f);
            map.put(cuisine, temp);

            cuisineDict.put(food, cuisine);
            foodDict.put(food, f);
        }
        
    }
    
    public void changeRating(String food, int newRating) {

        var cui = cuisineDict.get(food);
        PriorityQueue<Food> pq = map.get(cui);
        
        pq.remove(foodDict.get(food));
        Food nf = new Food(food, newRating);
        pq.add(nf);
        foodDict.put(food, nf);
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */