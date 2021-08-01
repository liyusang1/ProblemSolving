graph = dict()
graph['A'] = ['B', 'C']
graph['B'] = ['A', 'D']
graph['C'] = ['A', 'G', 'H', 'I']
graph['D'] = ['B', 'E', 'F']
graph['E'] = ['D']
graph['F'] = ['D']
graph['G'] = ['C']
graph['H'] = ['C']
graph['I'] = ['C', 'J']
graph['J'] = ['I']


def BFS(graph, startNode):
    visited, needVisited = list(), list()

    needVisited.append(startNode)

    while needVisited:
        node = needVisited.pop(0)
        if node not in visited:
            visited.append(node)
            needVisited.extend(graph[node])
    return visited


def DFS(graph, startNode):
    visited, needVisited = list(), list()

    needVisited.append(startNode)

    while needVisited:
        node = needVisited.pop()
        if node not in visited:
            visited.append(node)
            needVisited.extend(graph[node])
    return visited


# print(BFS(graph,"A"))


print(DFS(graph, "A"))

