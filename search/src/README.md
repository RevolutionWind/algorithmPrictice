#### 一、DFS&BFS
#####1.1 DFS代码模板:
 1.1.1 递归写法：
 ````
     public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> allResults = new ArrayList<>();
            if(root==null){
                return allResults;
            }
            travel(root,0,allResults);
            return allResults;
        }
        private void travel(TreeNode root,int level,List<List<Integer>> results){
            if(results.size()==level){
                results.add(new ArrayList<>());
            }
            results.get(level).add(root.val);
            if(root.left!=null){
                travel(root.left,level+1,results);
            }
            if(root.right!=null){
                travel(root.right,level+1,results);
            }
        }
 ````
 1.1.2 非递归写法：
 ````
    void dfs(Node root) {
      List<Integer> visited = new ArrayList<>();
      if(root == null) return Collections.emptyList();
      Stack<Node> stackNode = new Stack<>();
      stackNode.push(root);
      while (!stackNode.empty()) {
        Node node = stackNode.pop();
        visited.add(node)
        visited[node->val] = 1;
        for (int i = node->children.size() - 1; i >= 0; --i) {
            stackNode.push(node->children[i]);
        }
      }
      return ;
    }
 ````


#### 二、分支&回归
  2.1 代码模板：
  ````
  def divide_conquer(problem, param1, param2, ...):
    # 终结条件
    if problem is None:
     print_result
     return
    # prepare data
     data = prepare_data(problem)
     subproblems = split_problem(problem, data)
    # conquer subproblems
     subresult1 = self.divide_conquer(subproblems[0], p1, ...)
     subresult2 = self.divide_conquer(subproblems[1], p1, ...)
     subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result
     result = process_result(subresult1, subresult2, subresult3, …) 
  ```` 
  2.2 就是将一个大问题分解成几个小问题，小问题再分解，直至不能分解之后，进行解决（递归终止条件）。
       每层递归再将子问题回归，合并结果。
       