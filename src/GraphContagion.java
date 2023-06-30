import jas.engine.Sim;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections15.Transformer;



import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.algorithms.layout.util.Relaxer;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;


public class GraphContagion {
	
	/**
     * the graph
     */
    Forest<ContagionNode,String> graph;
    
    Layout layout;
    
    RadialTreeLayout<ContagionNode,String> radialLayout;
    
    VisualizationServer.Paintable rings;
    
    VisualizationViewer vv;
    public final DefaultModalGraphMouse graphMouse2 = new DefaultModalGraphMouse();

    private int count=0;
    private ContagionNode[] contagionNodes;
    private ContagionNode[] contagionNodesTmp;
    private int x, y;
    private ContagionNode root = null;
    
    private boolean firstTime = true;
    
    public VisualizationViewer<? extends Object, ? extends Object> getGraphVisualizer 
    (ArrayList<Contagion> contagionList, ArrayList<Node> nodesList, int x, int y)
	{
    	
    	contagionNodes = new ContagionNode[nodesList.size()];
    	contagionNodesTmp = new ContagionNode[nodesList.size()];
    	   	
    	
    	
    	// create a simple graph for the demo
        graph = new DelegateForest<ContagionNode,String>();
        
//        graph.addVertex("root");
        
        this.createTree(contagionList, nodesList);
        
//        layout = new TreeLayout<String,String>(graph);
//        layout = new FRLayout(graph);
        radialLayout = new RadialTreeLayout<ContagionNode,String>(graph);
        
		Transformer<ContagionNode, Paint> paintTransformer = new Transformer<ContagionNode, Paint>()
		{

			public Paint transform(ContagionNode n) {
				// TODO Auto-generated method stub
							
				return n.getNode().getColor();
			}
			
		};
//		
//		Transformer<String, Integer> sizeTransformer = new Transformer<String, Integer>()
//		{
//
//			public Integer transform(String n) {
//				// TODO Auto-generated method stub
//				return n.getSize();
//			}
//			
//		};
        
		
		this.x = x;
		this.y = y;
		radialLayout.setSize(new Dimension(x,y));
		
		vv =  new VisualizationViewer<ContagionNode,String>(radialLayout, new Dimension(x,y));
        vv.setBackground(Color.white);
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(paintTransformer);
        
        vv.setVertexToolTipTransformer(new ToStringLabeller());
        
       
        
        rings = new Rings();
		
		
		vv.setGraphMouse(graphMouse2);
		
		vv.addPreRenderPaintable(rings);
		
		this.vv.repaint();
		
		
//		Container content = new Container ();
//		content.add(vv);
		
		return vv;
	}
    
    private void createTree(ArrayList<Contagion> contagionList, ArrayList<Node> nodesList) {
    	
  
    	
    	for(int i = 0; i < contagionList.size(); i ++)
    	{
    		count++;
    		if (contagionList.get(i).value < 0)
    		{
    		graph.addEdge(nodesList.get(contagionList.get(i).bank1).toString() + "->" + 
    				nodesList.get(contagionList.get(i).bank2).toString() + "(" +  Sim.getAbsoluteTime()  + ")" 
    				, new ContagionNode((int) Sim.getAbsoluteTime(),nodesList.get(contagionList.get(i).bank1)) 
    				, new ContagionNode((int) Sim.getAbsoluteTime(),nodesList.get(contagionList.get(i).bank2)));
    	
    		}
    	}
    }
    
    public void update (ArrayList<Contagion> contagionList, final ArrayList<Node> nodesList)
	{
//		
//    	if (this.firstTime && contagionList.size() > 0)
//    	{
//    		graph.removeVertex(root);
//    		this.firstTime = false;
//    	}
    	
    	this.contagionNodes = this.contagionNodesTmp;
    	this.contagionNodesTmp = new ContagionNode [nodesList.size()];
    	
    	
    	for(int i = count; i < contagionList.size(); i ++)
    	{
    		
    		count++;
    		if (contagionList.get(i).value < 0)
    		{
    			if (this.contagionNodes[(nodesList.get(contagionList.get(i).bank1)).getId()] == null )
    			{
    				this.contagionNodes[(nodesList.get(contagionList.get(i).bank1)).getId()] =
    					new ContagionNode ((int)Sim.getAbsoluteTime(), nodesList.get(contagionList.get(i).bank1));
    			}
    			
    			this.contagionNodesTmp[(nodesList.get(contagionList.get(i).bank2)).getId()] =
					new ContagionNode ((int)Sim.getAbsoluteTime(), nodesList.get(contagionList.get(i).bank2));
    			
    			graph.addEdge(nodesList.get(contagionList.get(i).bank1).toString() + "->" + 
    					nodesList.get(contagionList.get(i).bank2).toString() + "(" +  Sim.getAbsoluteTime()  + ")" 
    					, this.contagionNodes[(nodesList.get(contagionList.get(i).bank1)).getId()] 
    					, this.contagionNodesTmp[(nodesList.get(contagionList.get(i).bank2)).getId()]);
    			
    			graph.removeVertex(root);

    		}
    	}
    	
    	
    	
    	radialLayout = new RadialTreeLayout<ContagionNode,String>(graph);
    	
    	vv.setGraphLayout(radialLayout);
		vv.getRenderContext().getMultiLayerTransformer().setToIdentity();

		vv.removePreRenderPaintable(rings);
		
		rings = new Rings();

		vv.addPreRenderPaintable(rings);

		

		
		

        
		
		this.vv.repaint();
		
//		Layout<Node,String> layout = vv.getGraphLayout();
//		layout.initialize();
//		Relaxer relaxer = vv.getModel().getRelaxer();
//		if(relaxer != null) {
////		if(layout instanceof IterativeContext) {
//			relaxer.stop();
//			relaxer.prerelax();
//			relaxer.relax();
//		}

		

//    	//      layout = new TreeLayout<String,String>(graph);
//    	layout = new FRLayout(graph);
//    	radialLayout = new RadialTreeLayout<String,String>(graph);
//
//
////    	this.x = x;
////    	this.y = y;
//    	radialLayout.setSize(new Dimension(x,y));
//
//    	vv =  new VisualizationViewer<String,String>(layout, new Dimension(x,y));
//    	vv.setBackground(Color.white);
//    	vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
//    	vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
//
//    	vv.setVertexToolTipTransformer(new ToStringLabeller());
//
//
//
//    	rings = new Rings();
//
//
//    	final DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
//    	vv.setGraphMouse(graphMouse);
//
//    	vv.setGraphLayout(radialLayout);
//    	vv.getRenderContext().getMultiLayerTransformer().setToIdentity();
////    	vv.addPreRenderPaintable(rings);
//

//    	this.vv.repaint();
		
	}
    
 /*   public void writeImage(String filename) {
        Layout layout = new RadialTreeLayout<V, E>(jungGraph);
        layout.setSize(innerSize);
        bvs = new VisualizationImageServer<V,E>(layout);
        // [...]
        BufferedImage image = (BufferedImage)bvs.getImage();
    }
   */ 
    public void setInitialNode (Node node)
    {
    	this.root = new ContagionNode((int)Sim.getAbsoluteTime(), node);
    	
    	this.contagionNodesTmp[node.getId()] = root;
    	
    	graph.addVertex(root);
    	
    	
    }
    
 class Rings implements VisualizationServer.Paintable {
    	
    	Collection<Double> depths;
    	
    	public Rings() {
    		depths = getDepths();
    	}
    	
    	private Collection<Double> getDepths() {
    		Set<Double> depths = new HashSet<Double>();
    		Map<ContagionNode,PolarPoint> polarLocations = radialLayout.getPolarLocations();
    		for(ContagionNode v : graph.getVertices()) {
    			PolarPoint pp = polarLocations.get(v);
    			depths.add(pp.getRadius());
    		}
    		return depths;
    	}

		public void paint(Graphics g) {
			g.setColor(Color.lightGray);
		
			Graphics2D g2d = (Graphics2D)g;
			Point2D center = radialLayout.getCenter();

			Ellipse2D ellipse = new Ellipse2D.Double();
			for(double d : depths) {
				ellipse.setFrameFromDiagonal(center.getX()-d, center.getY()-d, 
						center.getX()+d, center.getY()+d);
				Shape shape
= vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).
transform(ellipse);
				g2d.draw(shape);
			}
		}

		public boolean useTransform() {
			return true;
		}
    }
 
 class ContagionNode {
	 
	 int round;
	 Node node;
	 
	 public ContagionNode (int round, Node node)
	 {
		 this.round = round;
		 this.node = node;
	 }
	 
	 public String toString ()
	 {
		 return this.node.toString();
	 }
	 
	 public Node getNode()
	 {
		 return this.node;
	 }
	 
 }
}
