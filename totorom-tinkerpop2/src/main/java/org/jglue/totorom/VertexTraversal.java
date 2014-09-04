package org.jglue.totorom;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.tinkerpop.blueprints.Predicate;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.pipes.transform.TransformPipe;
import com.tinkerpop.pipes.util.structures.Pair;
import com.tinkerpop.pipes.util.structures.Table;
import com.tinkerpop.pipes.util.structures.Tree;

public interface VertexTraversal<SideEffect, LazySideEffect> extends Traversal<TVertex, SideEffect, LazySideEffect> {

	/**
	 * Check if the element has a property with provided key.
	 *
	 * @param key
	 *            the property key to check
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> has(String key);

	/**
	 * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of
	 * the Pipeline. If the incoming element has the provided key/value as check
	 * with .equals(), then let the element pass. If the key is id or label,
	 * then use respect id or label filtering.
	 *
	 * @param key
	 *            the property key to check
	 * @param value
	 *            the object to filter on (in an OR manner)
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> has(String key, Object value);

	/**
	 * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of
	 * the Pipeline. If the incoming element has the provided key/value as check
	 * with .equals(), then let the element pass. If the key is id or label,
	 * then use respect id or label filtering.
	 *
	 * @param key
	 *            the property key to check
	 * @param compareToken
	 *            the comparison to use
	 * @param value
	 *            the object to filter on
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> has(String key, Tokens.T compareToken, Object value);

	/**
	 * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of
	 * the Pipeline. If the incoming element has the provided key/value as check
	 * with .equals(), then let the element pass. If the key is id or label,
	 * then use respect id or label filtering.
	 *
	 * @param key
	 *            the property key to check
	 * @param predicate
	 *            the comparison to use
	 * @param value
	 *            the object to filter on
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> has(String key, Predicate predicate, Object value);

	/**
	 * Check if the element does not have a property with provided key.
	 *
	 * @param key
	 *            the property key to check
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> hasNot(String key);

	/**
	 * Add an IdFilterPipe, LabelFilterPipe, or PropertyFilterPipe to the end of
	 * the Pipeline. If the incoming element has the provided key/value as check
	 * with .equals(), then filter the element. If the key is id or label, then
	 * use respect id or label filtering.
	 *
	 * @param key
	 *            the property key to check
	 * @param value
	 *            the objects to filter on (in an OR manner)
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> hasNot(String key, Object value);

	/**
	 * Add an IntervalFilterPipe to the end of the Pipeline. If the incoming
	 * element has a value that is within the interval value range specified,
	 * then the element is allows to pass. If hte incoming element's value for
	 * the key is null, the element is filtered.
	 *
	 * @param key
	 *            the property key to check
	 * @param startValue
	 *            the start of the interval (inclusive)
	 * @param endValue
	 *            the end of the interval (exclusive)
	 * @return the extended Pipeline
	 */
	public <C> VertexTraversal<?, ?> interval(String key, Comparable<C> startValue, Comparable<C> endValue);

	/**
	 * Add an OutPipe to the end of the Pipeline. Emit the adjacent outgoing
	 * vertices of the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max adjacent vertices for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> out(int branchFactor, String... labels);

	/**
	 * Add an OutPipe to the end of the Pipeline. Emit the adjacent outgoing
	 * vertices of the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> out(String... labels);

	/**
	 * Add a InPipe to the end of the Pipeline. Emit the adjacent incoming
	 * vertices for the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max adjacent vertices for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> in(int branchFactor, String... labels);

	/**
	 * Add a InPipe to the end of the Pipeline. Emit the adjacent incoming
	 * vertices for the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> in(String... labels);

	/**
	 * Add a BothPipe to the end of the Pipeline. Emit both the incoming and
	 * outgoing adjacent vertices for the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max adjacent vertices for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> both(int branchFactor, String... labels);

	/**
	 * Add a BothPipe to the end of the Pipeline. Emit both the incoming and
	 * outgoing adjacent vertices for the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public VertexTraversal<?, ?> both(String... labels);

	/**
	 * Add an OutEdgesPipe to the end of the Pipeline. Emit the outgoing edges
	 * for the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max incident edges for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> outE(int branchFactor, String... labels);

	/**
	 * Add an OutEdgesPipe to the end of the Pipeline. Emit the outgoing edges
	 * for the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> outE(String... labels);

	/**
	 * Add an InEdgesPipe to the end of the Pipeline. Emit the incoming edges
	 * for the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max incident edges for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> inE(int branchFactor, String... labels);

	/**
	 * Add an InEdgesPipe to the end of the Pipeline. Emit the incoming edges
	 * for the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> inE(String... labels);

	/**
	 * Add a BothEdgesPipe to the end of the Pipeline. Emit both incoming and
	 * outgoing edges for the incoming vertex.
	 *
	 * @param branchFactor
	 *            the number of max incident edges for each incoming vertex
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> bothE(int branchFactor, String... labels);

	/**
	 * Add a BothEdgesPipe to the end of the Pipeline. Emit both incoming and
	 * outgoing edges for the incoming vertex.
	 *
	 * @param labels
	 *            the edge labels to traverse
	 * @return the extended Pipeline
	 */
	public EdgeTraversal<?, ?> bothE(String... labels);

	/**
	 * Get the next object emitted from the pipeline. If no such object exists,
	 * then a NoSuchElementException is thrown.
	 * 
	 * @param kind
	 *            The type of frame for the element.
	 * @return the next emitted object
	 */
	public <N extends FramedVertex> N next(Class<N> kind);

	/**
	 * Get the next object emitted from the pipeline. If no such object exists a
	 * new vertex is created.
	 * 
	 * @param kind
	 *            The type of frame for the element.
	 * @return the next emitted object
	 */
	public TVertex nextOrAdd();

	/**
	 * Get the next object emitted from the pipeline. If no such object exists a
	 * new vertex is created.
	 * 
	 * @param kind
	 *            The type of frame for the element.
	 * @return the next emitted object
	 */
	public <N extends FramedVertex> N nextOrAdd(Class<N> kind);

	/**
	 * Return the next X objects in the traversal as a list.
	 * 
	 * @param number
	 *            the number of objects to return
	 * @param kind
	 *            the type of frame to for each element.
	 * @return a list of X objects (if X objects occur)
	 */
	public <N extends FramedVertex> List<N> next(int amount, Class<N> kind);

	/**
	 * Return an iterator of framed elements.
	 * 
	 * @param kind
	 *            The kind of framed elements to return.
	 * @return An iterator of framed elements.
	 */
	public <N extends FramedVertex> Iterable<N> frame(Class<N> kind);

	/**
	 * Return a list of all the objects in the pipeline.
	 * 
	 * @param kind
	 *            The kind of framed elements to return.
	 * @return a list of all the objects
	 */
	public <N extends FramedVertex> List<N> toList(Class<N> kind);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an outgoing edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param namedStep
	 *            the step name that has the other vertex to link to
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkOut(String label, String namedStep);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param namedStep
	 *            the step name that has the other vertex to link to
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkIn(String label, String namedStep);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming and outgoing edge to incoming
	 * vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param namedStep
	 *            the step name that has the other vertex to link to
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkBoth(String label, String namedStep);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an outgoing edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkOut(String label, Vertex other);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an outgoing edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkOut(String label, FramedVertex other);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkIn(String label, Vertex other);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming and outgoing edge to incoming
	 * vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkBoth(String label, Vertex other);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming edge to incoming vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkIn(String label, FramedVertex other);

	/**
	 * Add a LinkPipe to the end of the Pipeline. Emit the incoming vertex, but
	 * have other vertex provide an incoming and outgoing edge to incoming
	 * vertex.
	 *
	 * @param label
	 *            the edge label
	 * @param other
	 *            the other vertex
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<List<TEdge>, TEdge> linkBoth(String label, FramedVertex other);

	/**
	 * Add a DuplicateFilterPipe to the end of the Pipeline. Will only emit the
	 * object if it has not been seen before.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> dedup();

	/**
	 * Add a DuplicateFilterPipe to the end of the Pipeline. Will only emit the
	 * object if the object generated by its function hasn't been seen before.
	 *
	 * @param dedupFunction
	 *            a function to call on the object to yield the object to dedup
	 *            on
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> dedup(TraversalFunction<TVertex, ?> dedupFunction);

	/**
	 * Add an ExceptFilterPipe to the end of the Pipeline. Will only emit the
	 * object if it is not in the provided collection.
	 *
	 * @param collection
	 *            the collection except from the stream
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> except(Collection<?> collection);

	/**
	 * Add an ExceptFilterPipe to the end of the Pipeline. Will only emit the
	 * object if it is not equal to any of the objects contained at the named
	 * steps.
	 *
	 * @param namedSteps
	 *            the named steps in the pipeline
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> except(String... namedSteps);

	/**
	 * Add an FilterFunctionPipe to the end of the Pipeline. The serves are an
	 * arbitrary filter where the filter criteria is provided by the
	 * filterFunction.
	 *
	 * @param filterFunction
	 *            the filter function of the pipe
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> filter(TraversalFunction<TVertex, Boolean> filterFunction);

	/**
	 * Add a RandomFilterPipe to the end of the Pipeline. A biased coin toss
	 * determines if the object is emitted or not.
	 *
	 * @param bias
	 *            the bias of the random coin
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> random(Double bias);

	/**
	 * Add a RageFilterPipe to the end of the Pipeline. Analogous to a high/low
	 * index lookup.
	 *
	 * @param low
	 *            the low end of the range
	 * @param high
	 *            the high end of the range
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> range(int low, int high);

	/**
	 * Add a RetainFilterPipe to the end of the Pipeline. Will emit the object
	 * only if it is in the provided collection.
	 *
	 * @param collection
	 *            the collection to retain
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> retain(Collection<?> collection);

	/**
	 * Add a RetainFilterPipe to the end of the Pipeline. Will only emit the
	 * object if it is equal to any of the objects contained at the named steps.
	 *
	 * @param namedSteps
	 *            the named steps in the pipeline
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> retain(String... namedSteps);

	/**
	 * Add an AggregatePipe to the end of the Pipeline. The objects prior to
	 * aggregate are greedily collected into an ArrayList.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Collection<TVertex>, Collection<TVertex>> aggregate();

	/**
	 * Add an AggregatePipe to the end of the Pipeline. The objects prior to
	 * aggregate are greedily collected into the provided collection.
	 *
	 * @param aggregate
	 *            the collection to aggregate results into
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Collection<TVertex>, Collection<TVertex>> aggregate(Collection<TVertex> aggregate);

	/**
	 * Add an AggregatePipe to the end of the Pipeline. The results of the
	 * function evaluated on the objects prior to the aggregate are greedily
	 * collected into the provided collection.
	 *
	 * @param aggregate
	 *            the collection to aggregate results into
	 * @param aggregateFunction
	 *            the function to run over each object prior to insertion into
	 *            the aggregate
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Collection<N>, Collection<N>> aggregate(Collection<TVertex> aggregate,
			TraversalFunction<TVertex, N> aggregateFunction);

	/**
	 * Add an AggregatePipe to the end of the Pipeline. The results of the
	 * function evaluated on the objects prior to the aggregate are greedily
	 * collected into an ArrayList.
	 *
	 * @param aggregateFunction
	 *            the function to run over each object prior to insertion into
	 *            the aggregate
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Collection<N>, Collection<N>> aggregate(TraversalFunction<TVertex, N> aggregateFunction);

	/**
	 * Add a GroupByPipe to the end of the Pipeline. Group the objects inputted
	 * objects according to a key generated from the object and a value
	 * generated from the object. The grouping map has values that are Lists.
	 *
	 * @param map
	 *            the map to store the grouping in
	 * @param keyFunction
	 *            the function that generates the key from the object
	 * @param valueFunction
	 *            the function that generates the value from the function
	 * @return the extended Pipeline
	 */
	public abstract <K, V> VertexTraversal<Map<K, List<V>>, Map<K, List<V>>> groupBy(Map<K, List<V>> map,
			TraversalFunction<TVertex, K> keyFunction, TraversalFunction<TVertex, V> valueFunction);

	/**
	 * Add a GroupByPipe to the end of the Pipeline. Group the objects inputted
	 * objects according to a key generated from the object and a value
	 * generated from the object. The grouping map has values that are Lists.
	 *
	 * @param keyFunction
	 *            the function that generates the key from the object
	 * @param valueFunction
	 *            the function that generates the value from the function
	 * @return the extended Pipeline
	 */
	public abstract <K, V> VertexTraversal<Map<K, List<V>>, Map<K, List<V>>> groupBy(TraversalFunction<TVertex, K> keyFunction,
			TraversalFunction<TVertex, V> valueFunction);

	/**
	 * Add a GroupByReducePipe to the end of the Pipeline. Group the objects
	 * inputted objects according to a key generated from the object and a value
	 * generated from the object. The grouping map has values that are Lists.
	 * When the pipe has no more incoming objects, apply the reduce function to
	 * the keyed Lists. The sideEffect is only fully available when the pipe is
	 * empty.
	 *
	 * @param reduceMap
	 *            a map to perform the reduce operation on (good for having a
	 *            later reference)
	 * @param keyFunction
	 *            the function that generates the key from the object
	 * @param valueFunction
	 *            the function that generates the value from the function
	 * @param reduceFunction
	 *            the function that reduces the value lists
	 * @return the extended Pipeline
	 */
	public abstract <K, V, V2> VertexTraversal<Map<K, V2>, Map<K, V2>> groupBy(Map<K, V2> reduceMap,
			TraversalFunction<TVertex, K> keyFunction, TraversalFunction<TVertex, V> valueFunction,
			TraversalFunction<List<V>, V2> reduceFunction);

	/**
	 * Add a GroupByReducePipe to the end of the Pipeline. Group the objects
	 * inputted objects according to a key generated from the object and a value
	 * generated from the object. The grouping map has values that are Lists.
	 * When the pipe has no more incoming objects, apply the reduce function to
	 * the keyed Lists. The sideEffect is only fully available when the pipe is
	 * empty.
	 *
	 * @param keyFunction
	 *            the function that generates the key from the object
	 * @param valueFunction
	 *            the function that generates the value from the function
	 * @param reduceFunction
	 *            the function that reduces the value lists
	 * @return the extended Pipeline
	 */
	public abstract <K, V, V2> VertexTraversal<Map<K, V2>, Map<K, V2>> groupBy(TraversalFunction<TVertex, K> keyFunction,
			TraversalFunction<TVertex, V> valueFunction, TraversalFunction<List<V>, V2> reduceFunction);

	/**
	 * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the
	 * Pipeline. A map is maintained of counts. The map keys are determined by
	 * the function on the incoming object. The map values are determined by the
	 * function on the incoming object (getA()) and the previous value (getB()).
	 *
	 * @param map
	 *            a provided count map
	 * @param keyFunction
	 *            the key function to determine map key
	 * @param valueFunction
	 *            the value function to determine map value
	 * @return the extended Pipeline
	 */
	public abstract <K> VertexTraversal<Map<K, Long>, Map<K, Long>> groupCount(Map<K, Long> map,
			TraversalFunction<TVertex, K> keyFunction, TraversalFunction<Pair<TVertex, Long>, Long> valueFunction);

	/**
	 * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the
	 * Pipeline. map is maintained of counts. The map keys are determined by the
	 * function on the incoming object. The map values are determined by the
	 * function on the incoming object (getA()) and the previous value (getB()).
	 *
	 * @param keyFunction
	 *            the key function to determine map key
	 * @param valueFunction
	 *            the value function to determine map value
	 * @return the extended Pipeline
	 */
	public abstract <K> VertexTraversal<Map<K, Long>, Map<K, Long>> groupCount(TraversalFunction<TVertex, K> keyFunction,
			TraversalFunction<Pair<TVertex, Long>, Long> valueFunction);

	/**
	 * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the
	 * Pipeline. A map is maintained of counts. The map keys are determined by
	 * the function on the incoming object. The map values are 1 plus the
	 * previous value for that key.
	 *
	 * @param map
	 *            a provided count map
	 * @param keyFunction
	 *            the key function to determine map key
	 * @return the extended Pipeline
	 */
	public abstract <K> VertexTraversal<Map<K, Long>, Map<K, Long>> groupCount(Map<K, Long> map,
			TraversalFunction<TVertex, K> keyFunction);

	/**
	 * Add a GroupCountPipe or GroupCountFunctionPipe to the end of the
	 * Pipeline. A map is maintained of counts. The map keys are determined by
	 * the function on the incoming object. The map values are 1 plus the
	 * previous value for that key.
	 *
	 * @param keyFunction
	 *            the key function to determine map key
	 * @return the extended Pipeline
	 */
	public abstract <K> VertexTraversal<Map<K, Long>, Map<K, Long>> groupCount(TraversalFunction<TVertex, K> keyFunction);

	/**
	 * Add a GroupCountPipe to the end of the Pipeline. A map is maintained of
	 * counts. The map keys are the incoming objects. The map values are 1 plus
	 * the previous value for that key.
	 *
	 * @param map
	 *            a provided count map
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Map<TVertex, Long>, Map<TVertex, Long>> groupCount(Map<TVertex, Long> map);

	/**
	 * Add a GroupCountPipe to the end of the Pipeline. A map is maintained of
	 * counts. The map keys are the incoming objects. The map values are 1 plus
	 * the previous value for that key.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Map<TVertex, Long>, Map<TVertex, Long>> groupCount();

	/**
	 * Add a SideEffectFunctionPipe to the end of the Pipeline. The provided
	 * function is evaluated and the incoming object is the outgoing object.
	 *
	 * @param sideEffectFunction
	 *            the function of the pipe
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> sideEffect(SideEffectFunction<TVertex> sideEffectFunction);

	/**
	 * Add a StorePipe to the end of the Pipeline. Lazily store the incoming
	 * objects into the provided collection.
	 *
	 * @param storage
	 *            the collection to store results into
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Collection<TVertex>, TVertex> store(Collection<TVertex> storage);

	/**
	 * Add a StorePipe to the end of the Pipeline. Lazily store the object
	 * returned by the function over the incoming object into the provided
	 * collection.
	 *
	 * @param storage
	 *            the collection to store results into
	 * @param storageFunction
	 *            the function to run over each object prior to insertion into
	 *            the storage collection
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Collection<N>, N> store(Collection<N> storage, TraversalFunction<TVertex, N> storageFunction);

	/**
	 * Add an StorePipe to the end of the Pipeline. An ArrayList storage
	 * collection is provided and filled lazily with incoming objects.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Collection<TVertex>, TVertex> store();

	/**
	 * Add a StorePipe to the end of the Pipeline. An ArrayList storage
	 * collection is provided and filled lazily with the return of the function
	 * evaluated over the incoming objects.
	 *
	 * @param storageFunction
	 *            the function to run over each object prior to insertion into
	 *            the storage collection
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Collection<N>, N> store(TraversalFunction<TVertex, N> storageFunction);

	/**
	 * Add a TablePipe to the end of the Pipeline. This step is used for
	 * grabbing previously seen objects the pipeline as identified by as-steps.
	 *
	 * @param table
	 *            the table to fill
	 * @param stepNames
	 *            the partition steps to include in the filling
	 * @param columnFunctions
	 *            the post-processing function for each column
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Table,Table> table(Table table, Collection<String> stepNames,
			TraversalFunction<?, ?>... columnFunctions);

	/**
	 * Add a TablePipe to the end of the Pipeline. This step is used for
	 * grabbing previously seen objects the pipeline as identified by as-steps.
	 *
	 * @param table
	 *            the table to fill
	 * @param columnFunctions
	 *            the post-processing function for each column
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Table, Table> table(Table table, TraversalFunction<?, ?>... columnFunctions);

	/**
	 * Add a TablePipe to the end of the Pipeline. This step is used for
	 * grabbing previously seen objects the pipeline as identified by as-steps.
	 *
	 * @param columnFunctions
	 *            the post-processing function for each column
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Table, Table> table(TraversalFunction<?, ?>... columnFunctions);

	/**
	 * Add a TablePipe to the end of the Pipeline. This step is used for
	 * grabbing previously seen objects the pipeline as identified by as-steps.
	 *
	 * @param table
	 *            the table to fill
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Table, Table> table(Table table);

	/**
	 * Add a TablePipe to the end of the Pipeline. This step is used for
	 * grabbing previously seen objects the pipeline as identified by as-steps.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<Table, Table> table();

	/**
	 * Add a TreePipe to the end of the Pipeline This step maintains an internal
	 * tree representation of the paths that have flowed through the step.
	 *
	 * @param tree
	 *            an embedded Map data structure to store the tree
	 *            representation in
	 * @param branchFunctions
	 *            functions to apply to each path object in a round robin
	 *            fashion
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Tree<N>, Tree<N>> tree(Tree<N> tree, TraversalFunction<?, N>... branchFunctions);

	/**
	 * Add a TreePipe to the end of the Pipeline This step maintains an internal
	 * tree representation of the paths that have flowed through the step.
	 *
	 * @param branchFunctions
	 *            functions to apply to each path object in a round robin
	 *            fashion
	 * @return the extended Pipeline
	 */
	public abstract <N> VertexTraversal<Tree<N>, Tree<N>> tree(TraversalFunction<?, N>... branchFunctions);

	/**
	 * Add an IdentityPipe to the end of the Pipeline. Useful in various
	 * situations where a step is needed without processing. For example, useful
	 * when two as-steps are needed in a row.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> identity();

	/**
	 * Add a MemoizePipe to the end of the Pipeline. This step will hold a Map
	 * of the objects that have entered into its pipeline section. If an input
	 * is seen twice, then the map stored output is emitted instead of
	 * recomputing the pipeline section.
	 *
	 * @param namedStep
	 *            the name of the step previous to memoize to
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> memoize(String namedStep);

	/**
	 * Add a MemoizePipe to the end of the Pipeline. This step will hold a Map
	 * of the objects that have entered into its pipeline section. If an input
	 * is seen twice, then the map stored output is emitted instead of
	 * recomputing the pipeline section.
	 *
	 * @param namedStep
	 *            the name of the step previous to memoize to
	 * @param map
	 *            the memoization map
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> memoize(String namedStep, Map<?, ?> map);

	/**
	 * Add an OrderPipe to the end of the Pipeline. This step will sort the
	 * objects in the stream in a default Comparable order.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> order();

	/**
	 * Add an OrderPipe to the end of the Pipeline. This step will sort the
	 * objects in the stream according to a comparator defined in the provided
	 * function.
	 *
	 * @param compareFunction
	 *            a comparator function of two objects of type E
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> order(Comparator<TVertex> compareFunction);

	/**
	 * Add an OrderPipe to the end of the Pipeline. This step will sort the
	 * objects in the stream in a default Comparable order.
	 *
	 * @param order
	 *            if the stream is composed of comparable objects, then
	 *            increment or decrement can be specified
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> order(TransformPipe.Order order);

	/**
	 * Add an OrderPipe to the end of the Pipeline. This step will sort the
	 * objects in the stream in a default Comparable order.
	 *
	 * @param order
	 *            if the stream is composed of comparable objects, then
	 *            increment or decrement can be specified
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> order(Tokens.T order);

	/**
	 * Wrap the previous step in an AsPipe. Useful for naming steps and is used
	 * in conjunction with various other steps including: loop, select, back,
	 * table, etc.
	 *
	 * @param name
	 *            the name of the AsPipe
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> as(String name);

	/**
	 * Add a CyclicPathFilterPipe to the end of the Pipeline. If the object's
	 * path is repeating (looping), then the object is filtered. Thus, what is
	 * emitted are those objects whose history is composed of unique objects.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> simplePath();

	/**
	 * Fill the provided collection with the objects in the pipeline.
	 *
	 * @param collection
	 *            the collection to fill
	 * @return the collection filled
	 */
	public abstract <N extends FramedVertex> Collection<N> fill(Collection<N> collection, Class<N> clazz);

	/**
	 * Causes the pipeline to be greedy up to this step.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> gatherScatter();

	/**
	 * Add an AndFilterPipe to the end the Pipeline. If the internal pipes all
	 * yield objects, then the object is not filtered. The provided pipes are
	 * provided the object as their starts.
	 *
	 * @param pipes
	 *            the internal pipes of the AndFilterPipe
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> and(TraversalFunction<TVertex, Traversal<?, ?, ?>>... pipes);

	/**
	 * Add an OrFilterPipe to the end the Pipeline. Will only emit the object if
	 * one or more of the provides pipes yields an object. The provided pipes
	 * are provided the object as their starts.
	 *
	 * @param pipes
	 *            the internal pipes of the OrFilterPipe
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> or(TraversalFunction<TVertex, Traversal<?, ?, ?>>... pipes);

	/**
	 * Add a NonTerminatingSideEffectCapPipe to the end of the Pipeline. When
	 * the previous step in the pipeline is implements SideEffectPipe, then it
	 * has a method called getSideEffect(). This step call the
	 * sideEffectFunction function with the side effect.
	 *
	 * @return the extended Pipeline
	 */
	public abstract VertexTraversal<?, ?> cap(SideEffectFunction<LazySideEffect> sideEffectFunction);

}