using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._03_Initializer
{
    class Test
    {
        static void Main(string[] args)
        {
            // 对象初始化器的使用
            Product product = new Product { ProductID = 1234, Name = "西瓜", Price = 2.3M }; //创建并初始化一个实例

            // 集合初始化器的使用
            List<Product> productList = new List<Product>
            {
                new Product { ProductID = 1234, Name = "西瓜", Price = 2.3M },
                new Product { ProductID = 2345, Name = "苹果", Price = 5.9M },
                new Product { ProductID = 3456, Name = "樱桃", Price = 4.6M },
            };

            // 数组使用初始化器
            string[] fruitArray = { "apple", "orange", "plum" };

            // 匿名类型使用初始化器
            var books = new { Title = "ASP.NET MVC 入门", Author = "小王", Price = 20 };

            // 字典类型使用初始化器
            Dictionary<string, int> fruitDictionary = new Dictionary<string, int>()
            {
                { "apple", 10 },
                { "orange", 20 },
                { "plum", 30 }
            };

            // 打印
            Console.WriteLine("对象初始化器：{0} {1} {2}", product.ProductID, product.Name, product.Price);
            foreach (Product p in productList)
            {
                Console.WriteLine("集合初始化器：{0} {1} {2}", p.ProductID, p.Name, p.Price);
            }
            Console.ReadKey();
        }
    }
}
