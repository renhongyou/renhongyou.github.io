using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._05_Lambda
{
    class Test
    {
        static void Main(string[] args)
        {
            // 创建商品集合
            IEnumerable<Product> products = new ShoppingCart
            {
                Products = new List<Product>
                {
                    new Product { Name = "西瓜", Category = "水果", Price = 2.3M },
                    new Product { Name = "苹果", Category = "水果", Price = 4.9M },
                    new Product { Name = "ASP.NET MCV 入门", Category = "书籍", Price = 19.5M },
                    new Product { Name = "ASP.NET MCV 提高", Category = "书籍", Price = 34.9M }
                }
            };

            // 用匿名函数定义一个具体的查询需求

            // 委托和匿名函数
            //Func<Product, bool> fruitFilter = delegate (Product product)
            //  {
            //      return product.Category == "水果";
            //  };

            // 使用Lambda表达式代替委托与匿名函数使得代码更简洁更人性化
            //Func<Product, bool> fruitFilter = product => product.Category == "水果";

            // 调用Filter，查询分类为“水果”的商品
            //IEnumerable<Product> filteredProducts = products.Filter(fruitFilter);

            // 上两行代码更进一步继续简化为一行
            IEnumerable<Product> filteredProducts = products.Filter(product => product.Category == "水果");

            // 打印结果
            foreach (Product product in filteredProducts)
            {
                Console.WriteLine("商品名称：{0}，单价：{1:c}", product.Name, product.Price);
            }
            Console.ReadKey();
        }
    }
}
