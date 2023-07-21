import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void uninoByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU + 1);
        }
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt){
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    
    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<Edge> edgesA = new ArrayList<Edge>();
	    
	    for(int i = 0; i < E;i++){
	        edgesA.add(new Edge( edges[i][0], edges[i][1], edges[i][2]));
	    }
	    
	    DisjointSet ds = new DisjointSet(V);
	    
	    Collections.sort(edgesA);
	    int mstWt = 0;
	    
	    for(int i = 0; i< edgesA.size(); i++){
	        int wt = edgesA.get(i).weight;
	        int u = edgesA.get(i).src;
	        int v = edgesA.get(i).dest;
	        
	        if(ds.findUPar(u) != ds.findUPar(v)){
	        mstWt += wt;
	        ds.unionBySize(u, v);
	    }
	    }
	    return mstWt;
	    
	}
	
	
	
}