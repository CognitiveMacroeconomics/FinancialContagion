import java.awt.Dimension;
import java.util.ArrayList;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;



public class Network {
	
	public static Graph getGraph(ArrayList<Node> nodes, double matrix[][])
	{
		Graph<Node, String> g = new DirectedSparseMultigraph<Node, String>();
		
		
		for(int i = 0; i < nodes.size(); i ++)
		{
			g.addVertex(nodes.get(i));
		}
		
		double count = 0;
		
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = 0; j < matrix.length; j ++)
			{
				if(matrix[i][j] > 0)
				{
					g.addEdge(nodes.get(i).getBank().getNameshort() + "->" + nodes.get(j).getBank().getNameshort(), nodes.get(i), 
							nodes.get(j), EdgeType.DIRECTED);
				}
			}
		}
		
		
		
		
		return g;
	}
	
	
	public static Graph getGraph()
	{
		Graph<String, Double> g = new DirectedSparseMultigraph<String, Double>();
		
		
		for(int i = 0; i < DataController.getBanksNameShortAndOutsideEntity().length; i ++)
		{
			g.addVertex(DataController.getBanksNameShortAndOutsideEntity()[i]);
		}
		
		
		g.addEdge(9.5, DataController.getBanksNameShortAndOutsideEntity()[2], 
				DataController.getBanksNameShortAndOutsideEntity()[3], EdgeType.DIRECTED);
		
		
		
		
		
		
		return g;
	}
	
	public static BasicVisualizationServer getGraphViewer()
	{

		Layout<Integer, String> layout = new CircleLayout(Network.getGraph());
		layout.setSize(new Dimension(840,693)); // sets the initial size of the space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<Integer,String> vv =
		new BasicVisualizationServer<Integer,String>(layout);
		vv.setPreferredSize(new Dimension(980,700)); //Sets the viewing area size
		
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
//		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		// Create a graph mouse and add it to the visualization component
		DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
		DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
		graphMouse.setMode(ModalGraphMouse.Mode.PICKING);
		vv.addMouseMotionListener(gm);// addMouseListener(gm);
		vv.addMouseMotionListener(graphMouse);
		return vv;
	}
}