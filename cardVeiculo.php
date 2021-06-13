                <div class="col-xs-12 col-sm-6 col-md-4 product">
						<a href="carro.php?id=<?=$dados->id?>"><br>
						<div class="ui link cards">
						<div class="card">
							<div class="product-img">
							<img  src="images/veiculos/<?=$dados->fotodestaque?>" alt="<?=$dados->modelo?>"/>
							<div class="product-hover">
									<div class="product-action text-center">
										<button class="btn btn-primary">Ver Detalhes</button>
									</div>
								</div>
							</div>
							<div class="content">
							<div class="header"><?=$dados->modelo?></div>
							<div class="meta">
								<?=$dados->marca?>
							</div>
							<div class="description"><b class="text-success">
							R$<?=number_format($dados->valor, 2, ",", ".")?></b>
							</div>
							</div>
							<div class="extra content">
							<span class="right floated">
							<?=$dados->anomodelo?>/<?=$dados->anofabricacao?>
							</span>
							<div class="text-left">
							<span>
								<?=$dados->tipo?>
							</span>
							</div>
							</div>
						</div>
						</div>

						</div>
						</a>
						<!-- .product end -->