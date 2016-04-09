# Breadth First Search
def breadth_first_search(graph, root):
	visited, queue = set(), [root]
	while queue:
		current = queue.pop(0)
		visited.add(current)
		for n in graph[current]:
			if n not in visited:
				visited.add(n)
				queue.append(n)
	return visited

graph = {'A': set(['B', 'C']),
        'B': set(['A', 'D', 'E']),
        'C': set(['A', 'F']),
        'D': set(['B']),
        'E': set(['B', 'F']),
        'F': set(['C', 'E'])
        
print(breadth_first_search(graph, 'A'))