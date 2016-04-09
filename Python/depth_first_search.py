# Depth First Search
def depth_first_search(graph, root):
	if not root:
		return
	visited, stack = set(), [root]
	while stack:
		current = stack.pop()
		if current not in visited:
			visited.add(current)
			stack.extend(graph[current] - visited)
	return visited

graph = {'A': set(['B', 'C']),
        'B': set(['A', 'D', 'E']),
        'C': set(['A', 'F']),
        'D': set(['B']),
        'E': set(['B', 'F']),
        'F': set(['C', 'E'])}

print(depth_first_search(graph, 'A'))