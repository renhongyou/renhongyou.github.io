using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._04_ExtensionMethod
{
    /// <summary>
    /// 购物车类（实现IEnumerable<Product>接口）
    /// </summary>
    public class ShoppingCart : IEnumerable<Product>
    {
        public List<Product> Products { get; set; }
        
        public IEnumerator<Product> GetEnumerator()
        {
            return Products.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
