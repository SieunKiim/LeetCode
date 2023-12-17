class FoodRatings {

     HashMap<String, PriorityQueue<Food>> cuisineBestFoods;
        HashMap<String, Food> foodMap;


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisineBestFoods = new HashMap<>();
            foodMap = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                putFood(food);
            }
        }

        public void changeRating(String food, int newRating) {
            Food food1 = foodMap.get(food);
            putFood(food1.changeRate(newRating));
        }

        public String highestRated(String cuisine) {
            return cuisineBestFoods.get(cuisine).peek().name;
        }

        private void putFood(Food food){
            foodMap.put(food.name, food);
            if (!cuisineBestFoods.containsKey(food.cuisine)) {
                cuisineBestFoods.put(food.cuisine, new PriorityQueue<>());
            }
            PriorityQueue<Food> foods = cuisineBestFoods.get(food.cuisine);
            foods.remove(food);
            foods.add(food);
        }

        class Food  implements Comparable<Food> {
            String name;
            String cuisine;
            int rate;

            public Food(String name, String cuisine, int rate) {
                this.name = name;
                this.cuisine = cuisine;
                this.rate = rate;
            }

            public Food changeRate(int num) {
                this.rate = num;
                return this;
            }
            @Override
            public int compareTo(Food o2) {
                if (this.rate == o2.rate) {
                    return this.name.compareTo(o2.name);
                }
                return o2.rate - this.rate;
            }
        }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */