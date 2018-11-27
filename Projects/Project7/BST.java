public class BST
{
	private class treenode
	{
		public Comparable data;
		public treenode left;
		public treenode right;
	}
	treenode root;
	int count;
	
	public BST()
	{
		root=null; count=0;
	}
	
	public void makeEmpty()
	{  root=null; count=0; }
	public int size()	{ return count; }
	
	private treenode inserthelp(Comparable x, treenode r)
	{
		if(r==null)
		{
			r=new treenode();
			r.data=x;
			r.left=r.right=null;
			return r;
		}
		if(x.compareTo(r.data)<0)
			r.left=inserthelp(x,r.left);
		else
			r.right=inserthelp(x,r.right);
		return r;
	}
	
	public void insert(Comparable x)
	{
		root=inserthelp(x,root);
		count++;
	}
	
	private Comparable lookhelp(Comparable x, treenode r)
	{
		if(r==null) return null;
		if(r.data.compareTo(x)==0)
			return r.data;
		if(x.compareTo(r.data)<0)
			return lookhelp(x,r.left);
		return lookhelp(x,r.right);
	}
	
	public Comparable lookup(Comparable x)
	{
		return lookhelp(x,root);
	}
	
	// deletion functions and stuff
	
	private Comparable min(treenode r)
	{
		if(r==null) return null;
		if(r.left==null) return r.data;
		return min(r.left);
	}
	
	private Comparable deleteditem;
	
	private treenode removehelp(Comparable x, treenode r)
	{
    if(r==null) return null;
		if(r.data.compareTo(x)==0)
		{
			// deleting item, handle 3 cases
			// 0 children:
			if(r.left==null && r.right==null)
			{
				deleteditem=r.data;
				count--;
				return null;
			}
			// 1 child
			if(r.left==null)
			{
				deleteditem=r.data;
				count--;
        		return r.right;				
			}
			if(r.right==null)
			{
				deleteditem=r.data;
				count--;
				return r.left;
			}
			// 2 children:
			Comparable is=min(r.right);
			Comparable saved=r.data;
			r.data=is;
			r.right=removehelp(is,r.right);
			deleteditem=saved;
			return r;
		}
		else if(x.compareTo(r.data)<0)
			r.left=removehelp(x,r.left);
		else
			r.right=removehelp(x,r.right);
    return r;		
	}
	
	public Comparable remove(Comparable x)
	{
	  deleteditem=null;
    root=removehelp(x,root);
    return deleteditem;		
	}
	
	// traversals
	
	public static final int PRE=-1;
	public static final int IN=0;
	public static final int POST=1;
	
	private Queue Q=new QueueLL();
	
	private void traverse(treenode r, int order)
	{
		if(r==null) return;
		
		if(order==PRE) Q.enqueue(r.data);
		traverse(r.left,order);
		if(order==IN) Q.enqueue(r.data);
		traverse(r.right,order);
		if(order==POST) Q.enqueue(r.data);
	}
	
	public void reset(int order)
	{
		Q.makeEmpty();
		traverse(root,order);
	}
	
	public boolean hasNext() 
	{ return !Q.isEmpty();}
	public Comparable getNext()
	{ return (Comparable)Q.dequeue(); }
	
	private void printhelper(treenode r)
	{
		if(r==null) return;
		printhelper(r.left);
		System.out.println(r.data);
		printhelper(r.right);
	}
	public void print()	{ printhelper(root); }
}