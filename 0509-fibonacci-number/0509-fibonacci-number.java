class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        int next=0;
        if(n==1) return n;
        else{
        for(int i=1;i<n;i++)
            {
                next=first+second;
                first=second;
                second=next;
            }
        return next;}
    }
}