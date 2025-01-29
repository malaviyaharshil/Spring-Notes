package com.mhm.SpringBootEcom.controller;

import com.mhm.SpringBootEcom.Product;
import com.mhm.SpringBootEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService prosuctService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts() {
        return new ResponseEntity<>(prosuctService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{pId}")
    public ResponseEntity<Product> getProductById(@PathVariable int pId){
        Product p= prosuctService.getByIdProduct(pId);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addImage(@RequestPart Product product,@RequestPart MultipartFile imageFile){
        Product updated =null;
        try{
             updated = prosuctService.addOrUpdateProduct(product,imageFile);
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int productId){
        Product product = prosuctService.getByIdProduct(productId);
        if(product!=null){
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,@RequestPart MultipartFile imageFile){
        Product updatedProduct =null;
        try{
            updatedProduct =prosuctService.addOrUpdateProduct(product,imageFile);
            return new ResponseEntity<>("updatedProduct", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product deletedProduct = prosuctService.getByIdProduct(id);
        if(deletedProduct!=null){
            prosuctService.deleteProduct(id);
            return new ResponseEntity<>("deletedProduct", HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("value") String value){
        List<Product> products = prosuctService.searchByKeyword(value);
        System.out.println("searching with "+value);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
