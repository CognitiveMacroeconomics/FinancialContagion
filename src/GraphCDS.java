import jas.engine.Sim;
import jas.graph.RelationalAgent;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays.*;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;
import org.jfree.util.ShapeList;

import test.SimpleGraphView2;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.algorithms.layout.util.Relaxer;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EllipseVertexShapeTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.ShapePickSupport;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.transform.shape.ShapeFlatnessTransformer;

public class GraphCDS {

	Graph<Node, String> graph;
	VisualizationViewer vv;
	ArrayList<Layout> layouts;
	private int x, y;
	public final DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();

	public VisualizationViewer<? extends Object, ? extends Object> getGraphVisualizer(
			Graph<Node, String> g, int x, int y) {
		this.graph = g;

		this.x = x;
		this.y = y;

		this.layouts = new ArrayList<Layout>();
		// this.layouts.add(new CircleLayout(g));
		this.layouts.add(new FRLayout(g));
		// this.layouts.add(new RadialTreeLayout((Forest) g));

		layouts.get(0).setSize(new Dimension(x, y));
		// layouts.get(1).setSize(new Dimension(x,y));

		Transformer<Node, Paint> paintTransformer = new Transformer<Node, Paint>() {

			public Paint transform(Node n) {
				// TODO Auto-generated method stub
				// System.out.println(n.toString() + " " +
				// n.getColor().toString());
				return n.getColor();
			}

		};

		Transformer<Node, Integer> sizeTransformer = new Transformer<Node, Integer>() {

			public Integer transform(Node n) {
				// TODO Auto-generated method stub
				return n.getSize();
			}

		};

		this.vv = new VisualizationViewer(layouts.get(layouts.size() - 1));
		this.vv.setPreferredSize(new Dimension(x, y));
		vv.setBackground(Color.WHITE);

		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());

		vv.getRenderContext().setVertexFillPaintTransformer(paintTransformer);
		ShapePickSupport pickSupport = (ShapePickSupport) vv.getPickSupport();
		pickSupport.setStyle(ShapePickSupport.Style.HIGHEST);

		// vv.getRenderContext().setve

		final DefaultModalGraphMouse graphMouse2 = new DefaultModalGraphMouse();
		graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);
		// graphMouse2.setMode(ModalGraphMouse.Mode.PICKING);

		vv.setGraphMouse(graphMouse);
		// vv.setGraphMouse(graphMouse2);

		vv.getRenderContext().setVertexShapeTransformer(
				new ClusterVertexShapeFunction());

		this.vv.repaint();

		return vv;
	}

	public void update(ArrayList<Node> nodeList, double matrix[][]) {

		PrintWriter pr;
		try {
			pr = new PrintWriter("AdjacencyMatrix.txt");

			for (int i = 0; i < matrix.length; i++) {
				pr.println(Arrays.deepToString(matrix));
			}
			pr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			PrintWriter pr2 = new PrintWriter("AdjacencyMatrix_02.csv");

			for (int i = 0; i < matrix.length; i++) {
				pr2.println(Arrays.toString(matrix[i]));
			}
			pr2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No such file exists.");
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					this.graph.removeEdge(nodeList.get(i).getBank()
							.getNameshort()
							+ "->" + nodeList.get(j).getBank().getNameshort());
				} else {
					this.graph
							.addEdge(nodeList.get(i).getBank().getNameshort()
									+ "->"
									+ nodeList.get(j).getBank().getNameshort(),
									nodeList.get(i), nodeList.get(j),
									EdgeType.DIRECTED);
				}
			}
		}

		// Layout<Node,String> layout = vv.getGraphLayout();
		// layout.initialize();
		// Relaxer relaxer = vv.getModel().getRelaxer();
		// if(relaxer != null) {
		// // if(layout instanceof IterativeContext) {
		// relaxer.stop();
		// relaxer.prerelax();
		// relaxer.relax();
		// }

		this.vv.repaint();

	}

	public static void main(String[] args) {
		GraphCDS g = new GraphCDS();

		JFrame frame = new JFrame("Simple Graph View 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(
				g.getGraphVisualizer(Network.getGraph(), 300, 300));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * a demo class that will create a vertex shape that is either a polygon or
	 * star. The number of sides corresponds to the number of vertices that were
	 * collapsed into the vertex represented by this shape.
	 * 
	 * @author Tom Nelson
	 * 
	 * @param <V>
	 */
	class ClusterVertexShapeFunction<V> extends
			EllipseVertexShapeTransformer<V> {

		ClusterVertexShapeFunction() {
			setSizeTransformer(new ClusterVertexSizeFunction<V>(20));
		}

		@Override
		public Shape transform(V v) {
			if (v instanceof Node) {
				int size = ((Node) v).getSize();

				// System.out.println("Circle == " + ((Node)v).SHAPE_CIRCLE +
				// "   -> " + ((Node)v).toString() + " = " +
				// ((Node)v).getShape());

				if (((Node) v).getShape() == ((Node) v).SHAPE_TRIANGLE) {
					// System.out.println("IN -> " );

					return new Triangle(new Point(0, -(int) size / 2),
							new Point((int) size / 2, (int) size / 2),
							new Point(-(int) size / 2, (int) size / 2));
				}

			}
			return super.transform(v);
		}
	}

	/**
	 * A demo class that will make vertices larger if they represent a collapsed
	 * collection of original vertices
	 * 
	 * @author Tom Nelson
	 * 
	 * @param <V>
	 */
	class ClusterVertexSizeFunction<V> implements Transformer<V, Integer> {
		int size;

		public ClusterVertexSizeFunction(Integer size) {
			this.size = size;
		}

		public Integer transform(V v) {
			if (v instanceof Node) {
				return ((Node) v).getSize();
			}
			return size;
		}
	}

}
