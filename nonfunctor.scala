object NonFunctorExample extends App { // Main object, containing the main program entry
  val originalTree = Node(5, Node(3, Empty, Empty), Node(8, Node(6, Empty, Empty), Empty))
  // Recursive function to first add 1 to each node value, then multiply by 2
  def increment(tree: Tree[Int]): Tree[Int] = tree match {
    case Empty => Empty
    case Node(value, left, right) => Node(value + 1, increment(left), increment(right))
  }
  def double(tree: Tree[Int]): Tree[Int] = tree match {
    case Empty => Empty
    case Node(value, left, right) => Node(value * 2, double(left), double(right))
  }
  def sum(tree: Tree[Int]): Int = tree match {
    case Empty => 0
    case Node(value, left, right) => value + sum(left) + sum(right)
  }
  // First add 1 to each node value, then multiply the result tree's node values by 2
  val incrementedTree = increment(originalTree)
  val doubledTree = double(incrementedTree)
  // Calculate the final sum of all node values in the tree
  val result = sum(doubledTree)
  println(result) // The output should be the same as using Functor
}
