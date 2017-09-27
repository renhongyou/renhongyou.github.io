using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._03_Initializer
{
    /// <summary>
    /// 商品类
    /// </summary>
    public class Product
    {
        /// <summary>
        /// 商品编号
        /// </summary>
        public int ProductID { get; set; }

        /// <summary>
        /// 商品名称
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// 商品描述
        /// </summary>
        public string Description { get; set; }

        /// <summary>
        /// 商品价格
        /// </summary>
        public decimal Price { get; set; }

        /// <summary>
        /// 商品分类
        /// </summary>
        public string Category { get; set; }
    }
}
