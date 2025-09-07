class TopKFreq {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=words.length;

        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> pq=new PriorityQueue<>((a,b) -> map.get(a).equals(map.get(b))?b.compareTo(a):map.get(a)-map.get(b));

        for(Map.Entry<String,Integer> e:map.entrySet()){
            pq.add(e.getKey());

            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        TopKFreq solution = new TopKFreq();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> result = solution.topKFrequent(words, k);
        System.out.println(result);
    }
}